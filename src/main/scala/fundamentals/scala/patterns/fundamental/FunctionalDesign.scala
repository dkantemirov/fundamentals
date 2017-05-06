package fundamentals.scala.patterns.fundamental

/**
 * Гарантирует, что каждый модуль компьютерной программы имеет только одну
 * обязанность и исполняет её с минимумом побочных эффектов на другие части программы.
 */
object FunctionalDesign extends App {
  println(Seq(1, 2, 3).foldLeft(1)(_ + _))
}
