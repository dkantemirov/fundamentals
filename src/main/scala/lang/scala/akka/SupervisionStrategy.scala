package lang.scala.akka

import akka.actor.{ Actor, ActorLogging, ActorRef, ActorSystem, Props }
import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

/**
 * Actor Systems supervision describes a dependency relationship between actors:
 * the supervisor delegates tasks to subordinates and therefore must respond to
 * their failures. When a subordinate detects a failure (i.e. throws an exception),
 * it suspends itself and all its subordinates and sends a message to its supervisor,
 * signaling failure. Depending on the nature of the work to be supervised and the
 * nature of the failure, the supervisor has a choice of the following four options:
 *  1. Resume the subordinate, keeping its accumulated internal state
 *  2. Restart the subordinate, clearing out its accumulated internal state
 *  3. Stop the subordinate permanently
 *  4. Escalate the failure, thereby failing itself (default)
 */
object SupervisionStrategy extends App {
  val system = ActorSystem("supervision")
  implicit val ec: ExecutionContext = system.dispatcher
  val subordinate: ActorRef = system.actorOf(Subordinate.props, "sub")
  val supervisor: ActorRef = system.actorOf(Props[Supervisor], "sv")

  // Default supervisor
  subordinate ! Subordinate.Message("a")
  subordinate ! Subordinate.Fail
  system.scheduler.scheduleOnce(1.seconds, subordinate, Subordinate.Message("b"))

  // Custom supervisor
  supervisor ! Subordinate.props
}

class Subordinate extends Actor with ActorLogging {
  import Subordinate._

  var state = 0

  def receive: Actor.Receive = {
    case Fail =>
      state += 5 // Discard its accumulated internal state
      2 / 0
    case Message(str) =>
      state += 1
      log.info(s"state: $state, message: $str")
    case Terminate =>
      log.info(s"state: $state")
      context.system.terminate()
  }
}
object Subordinate {
  case class Message(str: String)
  case object Fail
  case object Terminate

  def props: Props = Props(new Subordinate)
}

class Supervisor extends Actor {
  import akka.actor.OneForOneStrategy
  import akka.actor.SupervisorStrategy._
  import scala.concurrent.duration._
  import context.dispatcher

  override val supervisorStrategy: OneForOneStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1.minute) {
      case _: ArithmeticException => Resume
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _: Exception => Escalate
    }

  def receive: Receive = {
    case p: Props =>
      val supervised = context.actorOf(p, "sv-sub")
      supervised ! Subordinate.Message("c") // + 1
      supervised ! Subordinate.Fail // + 5. Keeping its accumulated internal state
      context.system.scheduler.scheduleOnce(1.seconds, supervised, Subordinate.Message("d")) // + 1
      context.system.scheduler.scheduleOnce(2.seconds, supervised, Subordinate.Terminate)
  }
}