package lang.scala.functional.combinators

import lang.scala.functional._

object Collect extends App {
  val sum1 = numbers.sum
  val sum2 = oddNumbers
    .zip(numbers collect { case x if x % 2 == 0 => x })
    .map({ case (x, y) => x + y })
    .sum

  assertResults(sum1, sum2)
}
