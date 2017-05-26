package lang.scala.functional.combinators

import lang.scala.functional._

object Partition extends App {
  val sum1 = numbers.sum
  val (p1, p2) = numbers.partition(_ % 2 == 0)
  val sum2 = p1.sum + p2.sum

  assertResults(sum1, sum2)
}
