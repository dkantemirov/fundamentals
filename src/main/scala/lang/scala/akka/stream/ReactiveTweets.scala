package lang.scala.akka.stream

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream._
import akka.stream.scaladsl._

/**
 * We will also consider the problem inherent to all non-blocking streaming solutions:
 * “What if the subscriber is too slow to consume the live stream of data?”.
 * Traditionally the solution is often to buffer the elements, but this can—and
 * usually will—cause eventual buffer overflows and instability of such systems.
 * Instead Akka Streams depend on internal backpressure signals that allow to
 * control what should happen in such scenarios.
 */
object ReactiveTweets extends App {
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()

  val authors: Source[Author, NotUsed] =
    TweetsSource.tweets
      .filter(_.hashtags.contains(Tweets.akkaTag))
      .map(_.author)

  // authors.runWith(Sink.foreach(println))
  val result = authors.runForeach(println)

  implicit val ec = system.dispatcher
  result.onComplete(_ => system.terminate())
}
