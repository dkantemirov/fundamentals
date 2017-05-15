package lang.scala.akka

import akka.actor._
import scala.concurrent.duration._

/**
 * The default mailbox for an actor is an UnboundedMailbox backed by Java’s ConcurrentLinkedQueue.
 * As the name indicates, this mailbox grows without bound and will end up crashing the JVM with
 * an OutOfMemoryError if the consumer significantly slower than the producer. If we want to be
 * able to signal the producer to slow down, the first step is to switch to a BoundedMailbox
 * backed by Java’s LinkedBlockingQueue that will block the producer if the mailbox is full.
 *
 * Blocking the producer forever is not a good solution because: Rule #1 of Akka => don't block
 * inside actors. The solution to this problem is provided to us by Akka in the form of a push
 * timeout for an Actor’s mailbox. A push timeout is exactly what it sounds like: when you try to
 * push a message to an actor’s mailbox, if the mailbox is full, the action will timeout and the
 * message will get routed to the DeadLetterActorRef.
 *
 * Configuring an actor to use a bounded mailbox with a 10 message capacity and a push timeout
 * of 100ms requires the following addition to the application.conf.
 *
 * While this example doesn’t actually implement back-pressure, it provides the infrastructure
 * for applying a back-pressure strategy. A possible strategy would be to send FastSender a
 * SlowDown message from within the Watcher for each dead letter received.
 * When FastSender receives a SlowDown message, it could either throttle itself or tell its
 * upstream systems to slow down. The SlowDown message also encapsulates the relevant DeadLetter
 * object to allow for retry logic.
 */
object BackPressureStrategy extends App {

  case object Ping

  val sys = ActorSystem("testSys")
  val slow: ActorRef = sys.actorOf(Props[SlowReceiver].withMailbox("bounded-mailbox"), "slow")
  val fast: ActorRef = sys.actorOf(Props(classOf[FastSender], slow), "fast")
  val watcher: ActorRef = sys.actorOf(Props(classOf[Watcher], slow), "watcher")
  sys.eventStream.subscribe(watcher, classOf[DeadLetter])

  fast ! Ping
}

/**
 * The SlowReceiver blocks for 100ms after printing each message it receives.
 * The blocking is only present to ensure that it’s mailbox fills up.
 */
class SlowReceiver extends Actor with ActorLogging {
  override def postStop() {
    log.info("SlowReceiver#postStop")
  }

  def receive: Actor.Receive = {
    case msg: String =>
      log.info(s"Received: $msg")
      Thread.sleep(100)
  }
}

object SlowReceiver {

  case class SlowDown(dl: DeadLetter)

}

/**
 * The FastSender waits for a kickoff message and then sends 15 messages to the
 * SlowReceiver and a PoisonPill to itself. After terminating itself, the actor’s
 * postStop hook schedules a PoisonPill to be sent to the SlowReceiver 2 seconds
 * after the FastSender has been terminated.
 */
class FastSender(slow: ActorRef) extends Actor with ActorLogging {
  override def postStop() {
    log.info("FastSender#postStop")
    context.system.scheduler.scheduleOnce(2.seconds, slow, PoisonPill)(context.dispatcher)
  }

  def receive: Actor.Receive = {
    case _ =>
      for (i <- 1 to 15) slow ! s"[$i]"
      log.info("Done sending all")
      self ! PoisonPill
  }
}

/**
 * The Watcher watches for and prints DeadLetters being sent to the SlowReceiver.
 * It also context.watches the SlowReceiver and terminates the actor system when
 * the SlowReceiver is killed.
 */
class Watcher(target: ActorRef) extends Actor with ActorLogging {
  private val targetPath = target.path

  override def preStart() {
    context.watch(target)
  }

  def receive: Actor.Receive = {
    case d: DeadLetter =>
      if (d.recipient.path.equals(targetPath)) {
        log.info(s"Timed out message: ${d.message.toString}")
      }

    case Terminated(`target`) =>
      context.system.terminate()
  }
}