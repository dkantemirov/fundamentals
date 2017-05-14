package fundamentals.scala.collections

import scala.collection.SortedMap

object ScalaSortedMap extends App {
  implicit object KeyLengthOrdering extends Ordering[String] {
    def compare(x: String, y: String): Int = x.length compare y.length
  }
  val sMap = SortedMap(
    "John" -> "(342)113-9878",
    "Richard" -> "(245)890-9045",
    "Donna" -> "(205)678-9823",
    "Ken" -> "(205)678-9823",
    "Zee" -> "(205)679-9823"
  )
  println(s"Sorted Map: $sMap")
  val firstKey: String = sMap.firstKey
  val lastKey: String = sMap.lastKey
  println(
    s"""First Key: $firstKey
      |Last Key: $lastKey
    """.stripMargin)
}
