package lang.scala.akka

import akka.actor.{ Actor, ActorLogging, ActorRef, ActorSystem, Props }

object CreatingActor extends App {
  class MyActor extends Actor with ActorLogging {

    import MyActor._

    def receive: Receive = {
      case Greeting(greeter) => log.info(s"I was greeted by $greeter.")
      case Goodbye => log.info("Someone said goodbye to me.")
    }
  }

  object MyActor {

    case class Greeting(from: String)

    case object Goodbye
  }
  import MyActor._

  val system = ActorSystem("mysystem")
  val myActor: ActorRef = system.actorOf(Props[MyActor], "myactor")
  myActor ! Greeting(system.name)
  myActor ! Goodbye
}

