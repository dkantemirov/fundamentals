package fundamentals.scala.lambda

object FunctionComposition extends App {
  // Create two functions
  val square: Long => Long = x => x * x
  val addOne: Long => Long = x => x + 1

  // Compose functions from the two functions
  val squareAddOne: Long => Long = square andThen addOne
  val addOneSquare: Long => Long = addOne andThen square

  // Test the functions
  val num = 5L
  println(s"Number : $square")
  println(s"Square and then add one: ${squareAddOne(num)}")
  println(s"Add one and then square: ${addOneSquare(num)}")
  println(s"Identity: ${identity(num)}")

  // Square the input, add one to the result, and square the result
  val chainedFunction =
    ((x: Long) => x * x).andThen(x => x + 1).andThen(x => x * x)
  println(chainedFunction(3L))
}
