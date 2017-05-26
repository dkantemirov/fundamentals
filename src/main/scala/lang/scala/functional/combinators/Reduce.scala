package lang.scala.functional.combinators

import lang.scala.functional._

object Reduce extends App {
  val sum1 = numbers.sum
  val sum2 = numbers.reduceLeft((acc: Int, v: Int) => acc + v)
  val sum3 = numbers.reduceLeft(_ + _)
  val sum4 = numbers.reduce(_ + _)

  assertResults(sum1, sum2, sum3, sum4)
}
