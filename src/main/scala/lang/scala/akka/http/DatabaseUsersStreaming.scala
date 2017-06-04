package lang.scala.akka.http

import akka.NotUsed
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.common.{ EntityStreamingSupport, JsonEntityStreamingSupport }
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.{ ActorMaterializer, ThrottleMode }
import akka.http.scaladsl.marshalling.{ Marshaller, ToEntityMarshaller }
import akka.stream.scaladsl.Source
import spray.json.DefaultJsonProtocol
import scala.concurrent.duration._

import scala.io.StdIn
import scala.util.Random

final case class User(name: String, id: String)

trait UserProtocol extends DefaultJsonProtocol {

  import spray.json._

  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User)

  val `vnd.example.api.v1+json`: MediaType.WithFixedCharset =
    MediaType.applicationWithFixedCharset("vnd.example.api.v1+json", HttpCharsets.`UTF-8`)
  val ct: ContentType.WithFixedCharset = ContentType.apply(`vnd.example.api.v1+json`)

  implicit def userMarshaller: ToEntityMarshaller[User] = Marshaller.oneOf(
    Marshaller.withFixedContentType(`vnd.example.api.v1+json`) { organisation ⇒
      HttpEntity(`vnd.example.api.v1+json`, organisation.toJson.compactPrint)
    }
  )
}

object DatabaseUsersStreaming extends App with UserProtocol {
  implicit val system = ActorSystem("api")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  implicit val jsonStreamingSupport: JsonEntityStreamingSupport = EntityStreamingSupport.json()
    .withContentType(ct)
    .withParallelMarshalling(parallelism = 10, unordered = false)

  // (fake) async database query api
  def dummyUser(id: String): User = User(s"User $id", id.toString)

  def fetchUsers(): Source[User, NotUsed] =
    Source
      .fromIterator(() ⇒ Iterator.fill(10000) {
        val id = Random.nextInt()
        dummyUser(id.toString)
      })
      .throttle(10, 1.second, 1, ThrottleMode.shaping)

  val route =
    pathPrefix("users") {
      get {
        complete(fetchUsers())
      }
    }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  println(s"Server online at http://localhost:8080/users\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture.flatMap(_.unbind()).onComplete(_ ⇒ system.terminate())
}