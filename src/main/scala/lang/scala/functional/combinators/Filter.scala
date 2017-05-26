package lang.scala.functional.combinators

import lang.scala.functional._

object Filter extends App {
  val sum1 = numbers.sum
  val sum2 = numbers.filter(_ % 2 == 0).sum + oddNumbers.sum

  assertResults(sum1, sum2)
}
