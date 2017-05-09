package fundamentals.scala.core

import java.util.{ ArrayList => JavaArrayList }

/**
 * Boilerplate Java analog [[fundamentals.java.core.InnerClass]]
 */
object InnerClass extends App {
  /**
   * Member Inner Class
   */
  class Car(val year: Int) {
    class Tire(val radius: Double)
  }

  /**
   * Local Inner Class
   */
  class TitleList(titleList: JavaArrayList[String]) {

    // A local inner class - TitleIterator
    def titleIterator: Iterator[String] = {
      class TileIterator extends Iterator[String] {
        private var count = 0
        def hasNext: Boolean = count < titleList.size
        def next(): String = {
          count += 1
          titleList.get(count)
        }
      }
      new TileIterator
    }
  }

  /**
   * Anonymous Inner Class
   */
  class TitleListWithAnonymousInnerClass(titleList: JavaArrayList[String]) {
    def addTitle(title: String): Boolean = titleList.add(title)
    def removeTitle(title: String): Boolean = titleList.remove(title)
    def titleIterator: Iterator[String] = {
      // An anonymous inner class
      new Iterator[String] {
        private var count = 0
        def hasNext: Boolean = count < titleList.size
        def next(): String = {
          count += 1
          titleList.get(count)
        }
      }
    }
  }

  /**
   * Creating Objects of Inner Classes
   */
  val car = new Car(2015)
  val tire = new car.Tire(15.0)
  println(tire.radius)
}
