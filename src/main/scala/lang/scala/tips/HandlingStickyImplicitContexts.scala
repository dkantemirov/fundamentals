package lang.scala.tips

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ ExecutionContext, Future }

object HandlingStickyImplicitContexts extends App {
  type EC[_] = ExecutionContext
  type Context[_] = SomeOtherContext

  def myMethod[T: EC](element: T): Future[Boolean] = ???

  //Non-polymorphic methods
  def myMethod[_: EC](element: Int): Future[Boolean] = ???

  def myMethod[_: EC: Context](element: Int): Future[Boolean] = ???

  //Which would be equivalent to:
  def myMethodWithoutCB(element: Int)(implicit
    ev1: ExecutionContext,
    ev2: SomeOtherContext): Future[Boolean] = ???

  //Multiple implicit contexts
  trait SomeOtherContext

  myMethod("hi")
}
