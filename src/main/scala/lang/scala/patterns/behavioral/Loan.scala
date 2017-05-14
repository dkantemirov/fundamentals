package lang.scala.patterns.behavioral

trait Resource {
  def dispose(): Unit
}

class SomeResource extends Resource {
  def dispose(): Unit = println("disposed")
}

/**
 * Ensures that a resource is deterministically disposed of once it goes out of scope.
 */
object Loan extends App {
  def using[A](r: Resource)(f: Resource => A): A =
    try f(r) finally r.dispose()

  using(new SomeResource) { resource =>
    println(resource)
  }
}
