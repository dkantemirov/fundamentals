package lang.scala.akka.stream

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream._
import akka.stream.scaladsl._

/**
 * Elements that can be used to form such “fan-out” (or “fan-in”) structures
 * are referred to as “junctions” in Akka Streams. One of these that we’ll be
 * using in this example is called Broadcast, and it simply emits elements
 * from its input port to all of its output ports.
 *
 * Akka Streams intentionally separate the linear stream structures (Flows)
 * from the non-linear, branching ones (Graphs) in order to offer the most
 * convenient API for both of these cases. Graphs can express arbitrarily
 * complex stream setups at the expense of not reading as familiarly as
 * collection transformations.
 */
object StreamBroadcast extends App {
  implicit val system = ActorSystem("reactive-tweets")
  implicit val materializer = ActorMaterializer()

  val writeAuthors: Sink[Author, NotUsed] = ???
  val writeHashtags: Sink[Hashtag, NotUsed] = ???
  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit b =>
    import GraphDSL.Implicits._

    val bcast = b.add(Broadcast[Tweet](2))
    TweetsSource.tweets ~> bcast.in
    bcast.out(0) ~> Flow[Tweet].map(_.author) ~> writeAuthors
    bcast.out(1) ~> Flow[Tweet].mapConcat(_.hashtags.toList) ~> writeHashtags
    ClosedShape
  })
  g.run()
}
