package lang.scala.akka.stream.combinators

import akka.actor.ActorSystem
import akka.stream._
import lang.scala.akka.stream.TweetsSource

object MapConcat extends App {
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()

  val result =
    TweetsSource.tweets
      .mapConcat(_.hashtags.toList)
      .runForeach(println)

  implicit val ec = system.dispatcher
  result.onComplete(_ => system.terminate())
}
