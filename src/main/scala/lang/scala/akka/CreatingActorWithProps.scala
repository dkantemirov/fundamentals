package lang.scala.akka

import akka.actor.{ Actor, ActorLogging, ActorRef, ActorSystem, Props }

object CreatingActorWithProps extends App {
  class MyActor(message: String) extends Actor with ActorLogging {

    import MyActor._

    def receive: Receive = {
      case Greeting(greeter) => log.info(s"I was greeted by $greeter. $message")
      case Goodbye => log.info(s"Someone said goodbye to me. $message")
    }
  }

  object MyActor {

    case class Greeting(from: String)

    case object Goodbye

    // Recommended Practices. Use static factory method
    def props(message: String): Props = Props(new MyActor(message))
  }
  import MyActor._

  val system = ActorSystem("mysystem")
  val myActor: ActorRef = system.actorOf(MyActor.props("Ok!"), "myactor")
  myActor ! Greeting(system.name)
  myActor ! Goodbye
}

