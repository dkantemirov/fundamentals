package fundamentals.scala.patterns.fundamental

class A {
  def foo(): Unit = println("foo")

  def bar(): Unit = println("bar")
}

class B {
  val a = new A

  def foo(): Unit = a.foo()

  def bar(): Unit = a.bar()
}

/**
 * Объект внешне выражает некоторое поведение, но в реальности передаёт
 * ответственность за выполнение этого поведения связанному объекту.
 */
object Delegation extends App {
  val b = new B
  b.bar()
  b.foo()
}
