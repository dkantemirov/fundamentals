package lang.scala.core

abstract class Abstraction {
  val i = 1 // immutable state

  def count: Int
}

object Abstraction {
  def foo(): Unit = println("foo")
}

class AbstractionImpl extends Abstraction {
  def count: Int = {
    Abstraction.foo() // companion object static method
    i
  }
}

object AbstractionImpl extends App {
  new AbstractionImpl().count
}

