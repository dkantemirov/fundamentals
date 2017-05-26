package lang.scala.functional.combinators

import lang.scala.functional._

object Map extends App {
  val sum1 = numbers.sum
  val sum2 = evenNumbers
    .zip(oddNumbers)
    .map({ case (x, y) => x + y })
    .sum

  assertResults(sum1, sum2)
}
