package lang.scala.functional.combinators

import lang.scala.functional._

object Flatten extends App {
  val sum1 = numbers.sum
  val sum2 = Seq(numbers)
    .flatten
    .sum

  assertResults(sum1, sum2)
}
