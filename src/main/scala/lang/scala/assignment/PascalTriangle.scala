package lang.scala.assignment

object PascalTriangle {
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || r == c) 1 else pascal(c-1, r-1) + pascal(c, r-1)
  def main(args: Array[String]): Unit = {
//    for (i <- 0 to 10) {
//      for (j <- 0 to i) print(pascal(i, j) + " ")
//      println("")
//    }
  }
}
