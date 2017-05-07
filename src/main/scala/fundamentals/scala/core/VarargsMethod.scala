package fundamentals.scala.core

object VarargsMethod extends App {
  def varargs(i: Int*): Unit = for (v <- i) println(v)
  varargs(1, 2, 3, 4, 5)
}
