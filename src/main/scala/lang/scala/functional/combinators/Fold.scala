package lang.scala.functional.combinators

import lang.scala.functional._

//noinspection SimplifiableFoldOrReduce
object Fold extends App {
  val sum1 = numbers.sum
  val sum2 = numbers.foldLeft(0)((acc: Int, v: Int) => acc + v)
  val sum3 = numbers.foldLeft(0)(_ + _)
  val sum4 = numbers.fold(0)(_ + _)
  val sum5 = (0 /: numbers)(_ + _)

  assertResults(sum1, sum2, sum3, sum4, sum5)
}
