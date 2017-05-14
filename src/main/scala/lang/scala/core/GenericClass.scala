package lang.scala.core

class GenericClass[A, B] {
  def foo(a: A): Unit = ???
  def bar[C](c: C): Unit = ???
}
