package lang.scala.functional.combinators

import lang.scala.functional._

object ZipWithIndex extends App {
  val sum1 = numbers.sum
  val sum2 = numbers
    .zipWithIndex
    .map(_._2 + 1)
    .sum

  assertResults(sum1, sum2)
}
