package lang.scala.functional.combinators

import lang.scala.functional._

object FlatMap extends App {
  val sum1 = (numbers ++ numbers.map(_ + 1)).sum
  val sum2 = numbers
    .flatMap(x => Seq(x, x + 1))
    .sum

  assertResults(sum1, sum2)

  val pairs = for {
    x <- List(1,2)
    y <- List(2,3)
  } yield (x,y)

  // map one to many
  val list = pairs.flatMap({case (x, y) => Seq(x,y)})

  println(list)
}
