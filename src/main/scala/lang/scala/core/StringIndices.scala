package lang.scala.core

object StringIndices extends App {
  val str = "Example Scala string with indentation using index value"
  val words: Array[String] = str.split(" ")

  words
    .zipWithIndex
    .map({
      case (w, i) =>
        val ind = " " * i
        s"$ind$w"
    })
    .foreach(println)
}
