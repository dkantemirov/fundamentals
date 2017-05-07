package fundamentals.scala.core

class GenericClass[A, B] {
  def methodWithTypeParameter(a: A): Unit = ???
  def methodWithTypeParameter1[C](c: C): Unit = ???
}
