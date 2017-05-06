package fundamentals.scala.patterns.behavioral

/**
 * Scala Tuple or case class.
 *
 * Value object is a small immutable object that represents
 * a simple entity whose equality isn’t based on identity.
 * Value objects are equal if all their fields are equal.
 */
object ValueObject extends App {
  type Point = (Int, Int) // Tuple2[Int, Int]

  val point: Point = (1, 2)
  val point1 = Point1(1, 2)

  case class Point1(x: Int, y: Int)
}
