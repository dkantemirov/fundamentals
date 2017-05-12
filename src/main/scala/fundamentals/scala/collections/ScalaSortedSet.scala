package fundamentals.scala.collections

import fundamentals.java.collections.JavaSortedSet.Person

import scala.collection.SortedSet

/**
 * Java Sorted Set [[fundamentals.java.collections.JavaSortedSet]]
 */
object ScalaSortedSet extends App {
  def treeSet(): Unit = {
    // TreeSet is default impl of SortedSet
    val sortedNames: SortedSet[String] = SortedSet("John", "Adam", "Eve", "Donna")
    println(sortedNames)
  }

  def treeSetWithCustomOrdering(): Unit = {
    implicit object NameOrdering extends Ordering[Person] {
      def compare(x: Person, y: Person): Int = x.getName compare y.getName
    }
    val personsById = SortedSet(
      new Person(1, "John"),
      new Person(2, "Adam"),
      new Person(3, "Eve"),
      new Person(4, "Donna"),
      new Person(4, "Donna")
    )
    personsById foreach println
    val personsByName = SortedSet(
      new Person(1, "John"),
      new Person(2, "Adam"),
      new Person(3, "Eve"),
      new Person(4, "Donna"),
      new Person(4, "Kip")
    )
    personsByName foreach println
  }

  treeSet()
  treeSetWithCustomOrdering()
}
