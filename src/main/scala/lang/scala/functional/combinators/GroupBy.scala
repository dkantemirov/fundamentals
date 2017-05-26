package lang.scala.functional.combinators

import lang.scala.functional._

object GroupBy extends App {
  val sum1 = numbers.sum
  val m = numbers.groupBy(x => if (x % 2 == 0) "even" else "odd")
  val sum2 = m("even").sum + m("odd").sum

  assertResults(sum1, sum2)
}
