package lang.scala.assignment

object CountSignChange {
  def count(s: Seq[Int]): Int = {
    def isPositive(v: Int) = if (v < 0) false else true
    ((0, isPositive(s.head)) /: s.tail) ({
      case ((count, sign), num) =>
        val a = isPositive(num)
        if (sign != a) (count + 1, a) else (count, a)
    })._1
  }

  def main(args: Array[String]): Unit = {
    println(count(Seq(-1, -45, 4, 0, -5, 45, 5, -7, 0, 8, -7, 5, 1, 3, -7, 7)))
  }
}
