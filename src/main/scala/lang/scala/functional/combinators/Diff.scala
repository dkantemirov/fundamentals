package lang.scala.functional.combinators

import lang.scala.functional._

object Diff extends App {
  val sum1 = numbers.sum
  val sum2 = numbers.diff(evenNumbers).sum + evenNumbers.sum

  assertResults(sum1, sum2)
}
