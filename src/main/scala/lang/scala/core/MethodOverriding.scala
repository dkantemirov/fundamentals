package lang.scala.core

object MethodOverriding extends App {
  class A {
    def print(): Unit = println("A")
  }
  class B extends A {
    override def print(): Unit = {
      super.print()
      println("B")
    }
  }
  new B().print()
}
