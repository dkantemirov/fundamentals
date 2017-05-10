package fundamentals.scala.lambda

object LambdaExpressions extends App {
  // Takes an int parameter and returns the parameter value incremented by 1
  val inc: Int => Int = x => x + 1
  println(inc(5)) // 6

  // Takes two int parameters and returns their sum
  val sum: (Int, Int) => Int = (x, y) => x + y
  println(sum(1, 2)) // 3

  // Takes two int parameters and returns the maximum of the two
  val max: (Int, Int) => Int = (x, y) => if (x > y) x else y
  println(max(1, 2)) // 2

  // Takes no parameters and returns void
  val run: () => Unit = () => {}
}
