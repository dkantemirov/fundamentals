package lang.scala.akka.stream

import akka.actor.ActorSystem
import akka.stream._

import scala.concurrent.duration._
import akka.stream.scaladsl._

/**
 *  One aspect that is not immediately visible deserves mention, though: if you try and
 *  set the streams to produce a billion numbers each then you will notice that your JVM
 *  does not crash with an OutOfMemoryError, even though you will also notice that
 *  running the streams happens in the background, asynchronously (this is the reason
 *  for the auxiliary information to be provided as a Future). The secret that makes
 *  this work is that Akka Streams implicitly implement pervasive flow control,
 *  all combinators respect back-pressure. This allows the throttle combinator to signal
 *  to all its upstream sources of data that it can only accept elements at a certain
 *  rate—when the incoming rate is higher than one per second the throttle combinator
 *  will assert back-pressure upstream.
 */
object TimeBasedProcessing extends App {
  implicit val system = ActorSystem("timebased-processing")
  implicit val materializer = ActorMaterializer()

  val result = StreamSource.factorials
    .zipWith(Source(0 to 100))((num, idx) => s"$idx! = $num")
    .throttle(1, 1.second, 1, ThrottleMode.shaping)
    .runForeach(println)

  implicit val ec = system.dispatcher
  result.onComplete(_ => system.terminate())
}
