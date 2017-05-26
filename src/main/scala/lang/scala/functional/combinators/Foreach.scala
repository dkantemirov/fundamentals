package lang.scala.functional.combinators

import lang.scala.functional._

object Foreach extends App {
  val sum1 = numbers.sum
  var sum2 = 0
  numbers.foreach(sum2 += _)

  assertResults(sum1, sum2)
}
