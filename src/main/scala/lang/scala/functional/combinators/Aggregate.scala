package lang.scala.functional.combinators

import lang.scala.functional._

object  Aggregate extends App {
  val sum1 = numbers.sum
  val sum2 = numbers.aggregate(0)(
    (acc: Int, v: Int) => acc + v,
    (v1: Int, v2: Int) => v1 + v2
  )
  val sum3 = numbers.aggregate(0)(_ + _, _ + _)

  assertResults(sum1, sum2, sum3)
}
