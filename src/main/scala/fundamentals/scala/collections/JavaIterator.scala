package fundamentals.scala.collections

import java.{ util => ju }

object JavaIterator extends App {
  def iterator(): Unit = {
    val list = new ju.ArrayList(ju.Arrays.asList(1, 2, 3, 4, 5))

    // Using an Iterator
    val iterator = list.iterator()
    while (iterator.hasNext) println(iterator.next())
  }
  iterator()
}
