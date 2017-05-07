package fundamentals.scala.collections

import java.util
import java.util.ArrayList

import scala.collection.mutable.ArrayBuffer

object JavaArrayList extends App {
  val arrList: util.ArrayList[Int] = new util.ArrayList()
  arrList.add(1)
  arrList.add(2)
  arrList.add(3)
  arrList.add(4)

  var i = 0
  while (i < arrList.size()) {
    println(arrList.get(i))
    i += 1
  }

  // Alternative Scala mutable collection
  val list = ArrayBuffer(1, 2, 3)
  list += 4 // example mutate the list
}
