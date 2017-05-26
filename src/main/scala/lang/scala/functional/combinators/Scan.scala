package lang.scala.functional.combinators

import lang.scala.functional._

object Scan extends App {
  val sum1 = numbers.sum
  val sum2 = numbers.scanLeft(0)((acc, v) => acc + v).last
  val sum3 = numbers.scanLeft(0)(_ + _).last
  val sum4 = numbers.scanRight(0)(_ + _).head
  val sum5 = numbers.scan(0)(_ + _).last

  assertResults(sum1, sum2, sum3, sum4, sum5)
}
