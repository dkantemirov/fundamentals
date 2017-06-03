package lang.scala.akka.stream

import java.nio.file.Paths

import akka.actor.ActorSystem
import akka.stream.{ ActorMaterializer, IOResult }
import akka.stream.scaladsl._
import akka.util.ByteString

import scala.concurrent.Future

object ReusableStreamSink extends App {
  implicit val system = ActorSystem("reusable-sink")
  implicit val materializer = ActorMaterializer()

  /**
   * One of the nice parts of Akka Streams—and something that other stream libraries do
   * not offer—is that not only sources can be reused like blueprints, all other elements
   * can be as well. We can take the file-writing Sink, prepend the processing steps
   * necessary to get the ByteString elements from incoming strings and package that up
   * as a reusable piece as well. Since the language for writing these streams always
   * flows from left to right (just like plain English), we need a starting point that
   * is like a source but with an “open” input. In Akka Streams this is called a Flow
   */
  def lineSink(filename: String): Sink[String, Future[IOResult]] =
    Flow[String]
      .map(s => ByteString(s + "\n"))
      .toMat(FileIO.toPath(Paths.get(filename)))(Keep.right)

  RangeSource.main(Array.empty)

  val result: Future[IOResult] =
    StreamSource.factorials
      .map(_.toString)
      .runWith(lineSink("target/factorial2.txt"))

  implicit val ec = system.dispatcher
  result.onComplete(_ => system.terminate())
}
