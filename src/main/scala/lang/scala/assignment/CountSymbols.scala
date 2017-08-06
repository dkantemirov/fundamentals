package lang.scala.assignment

/**
  * Count symbols in string and return as Map
  */
object CountSymbols {
  def count(s: String): Map[Char, Int] =
    (Map[Char, Int]() /: s)((m, char) => m + (char -> s.count(_ == char)))

  def main(args: Array[String]): Unit = {
    println(count("Hello scala!"))
  }
}
