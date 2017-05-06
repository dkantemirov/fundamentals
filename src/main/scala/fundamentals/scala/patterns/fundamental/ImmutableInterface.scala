package fundamentals.scala.patterns.fundamental

trait ImmutablePoint {
  def x: Int

  def y: Int
}

class Point(var x: Int, var y: Int) extends ImmutablePoint

/**
 * Создание неизменяемого объекта.
 */
object ImmutableInterface extends App {
  val p: ImmutablePoint = new Point(5, 10)
  // p.x = 2 !!! Compile error
  println(p.x, p.y)
}
