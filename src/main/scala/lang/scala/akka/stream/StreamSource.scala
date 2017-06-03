package lang.scala.akka.stream

import akka.{ Done, NotUsed }
import akka.actor.ActorSystem
import akka.util.ByteString

import scala.concurrent._
import java.nio.file.Paths

import akka.stream._
import akka.stream.scaladsl._
import lang.scala.akka.stream.StreamSource.source

object StreamSource {
  // Simple source, emitting the integers 1 to 100
  val source: Source[Int, NotUsed] = Source(1 to 100)

  val factorials: Source[BigInt, NotUsed] =
    source.scan(BigInt(1))((acc, next) => acc * next)
}

object RangeSource extends App {
  implicit val system = ActorSystem("range-source")

  /**
   * There are other ways to create a materializer, e.g. from an ActorContext
   * when using streams from within Actors. The Materializer is a factory for
   * stream execution engines, it is the thing that makes streams run.
   *
   * ActorMaterializer will execute every step of a transformation pipeline
   * within its own Actor. The required ActorRefFactory (which can be either
   * an ActorSystem or an ActorContext) will be used to create one actor that
   * in turn creates actors for the transformation steps.
   */
  implicit val materializer = ActorMaterializer()

  /**
   * Having created this source means that we have a description of how to emit
   * the first 100 natural numbers, but this source is not yet active. In order
   * to get those numbers out we have to run it:
   */
  val done: Future[Done] = source.runForeach(println(_))(materializer)

  val result: Future[IOResult] =
    StreamSource.factorials
      .map(num => ByteString(s"$num\n"))
      .runWith(FileIO.toPath(Paths.get("target/factorials.txt")))

  implicit val ec = system.dispatcher
  result.onComplete(_ => system.terminate())
}

object TweetsSource {
  val tweets: Source[Tweet, NotUsed] = Source(Tweets.data)
}

object SeqSource extends App {
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()

  val result =
    TweetsSource.tweets
      .filterNot(_.hashtags.contains(Tweets.akkaTag))
      .mapConcat(_.hashtags)
      .map(_.name.toUpperCase)
      .runWith(Sink.foreach(println))

  implicit val ec = system.dispatcher
  result.onComplete(_ => system.terminate())
}

final case class Author(handle: String)

final case class Hashtag(name: String)

final case class Tweet(author: Author, timestamp: Long, body: String) {
  def hashtags: Set[Hashtag] =
    body.split(" ").collect { case t if t.startsWith("#") => Hashtag(t) }.toSet
}

object Tweets {
  val data: List[Tweet] =
    Tweet(Author("rolandkuhn"), System.currentTimeMillis, "#akka rocks!") ::
      Tweet(Author("patriknw"), System.currentTimeMillis, "#akka !") ::
      Tweet(Author("bantonsson"), System.currentTimeMillis, "#akka !") ::
      Tweet(Author("drewhk"), System.currentTimeMillis, "#akka !") ::
      Tweet(Author("ktosopl"), System.currentTimeMillis, "#akka on the rocks!") ::
      Tweet(Author("mmartynas"), System.currentTimeMillis, "wow #akka !") ::
      Tweet(Author("akkateam"), System.currentTimeMillis, "#akka rocks!") ::
      Tweet(Author("bananaman"), System.currentTimeMillis, "#bananas rock!") ::
      Tweet(Author("appleman"), System.currentTimeMillis, "#apples rock!") ::
      Tweet(Author("drama"), System.currentTimeMillis, "we compared #apples to #oranges!") ::
      Nil

  val akkaTag = Hashtag("#akka")
}

