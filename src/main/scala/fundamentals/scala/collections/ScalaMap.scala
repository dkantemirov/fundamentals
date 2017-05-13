package fundamentals.scala.collections

import scala.collection.mutable

/**
 * Java Map [[fundamentals.java.collections.JavaMap]]
 */
object ScalaMap extends App {
  def hashMap(): Unit = {
    val map = Map(
      "John" -> "(342)113-9878",
      "Richard" -> "(245)890-9045",
      "Donna" -> "(205)678-9823",
      "Ken" -> "(205)678-9823"
    )
    val donnaPhone = map("Donna")
    println(
      s"""Map: $map
         |Map size: ${map.size}
         |Map is empty: ${map.isEmpty}
         |Map contains Donna key: ${map.contains("Donna")}
         |Donna Phone: $donnaPhone""".stripMargin
    )
    (map - "Donna") foreach { case (k, v) => println(s"key=$k, value=$v") }
  }
  /**
   * A hash map with references to entries which are weakly reachable.
   * Entries are removed from this map when the key is no longer (strongly)
   * referenced. This class wraps java.util.WeakHashMap.
   */
  def weakHashMap(): Unit = {
    val map = mutable.WeakHashMap(
      "John" -> "(342)113-9878",
      "Eric" -> "(245)890-9045",
      "Duke" -> "(205)678-9823",
      "Ken" -> "(205)678-9823"
    )
    val katePhone = map.getOrElse("Kate", "(205)677-7711")
    println("Kate phone: " + katePhone)
    map += "Kate" -> katePhone
    map
      .map({ case (k, v) => if (k(0) == 'K') (k, "hidden") else (k, v) })
      .foreach({ case (k, v) => println(s"key=$k, value=$v") })
  }
  hashMap()
  weakHashMap()
}
