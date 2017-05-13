package fundamentals.scala.collections

/**
 * Java List [[fundamentals.java.collections.JavaList]]
 */
object ScalaList extends App {
  def linkedList(): Unit = {
    val list = (Seq("Eric", "David", "Piter", "Mark")
      .dropWhile(_ == "Mark") ++ Seq("Fred", "Bart") diff Seq("Mark", "Kate")).sorted
    println(s"Size of List: ${list.size}")
    println(s"List: $list")
  }
  linkedList()
}
