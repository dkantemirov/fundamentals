package lang.scala.collections

import scala.collection.immutable.ListSet
import scala.collection.mutable

object ScalaSet extends App {
  def hashSet(): Unit = {
    val s1: Set[String] = Set("John", "Donna", "Ken", "Ken")
    val s2: Set[String] = s1 ++: Set("Elen", "Sara")
    println(s"s1: $s1")
    println(s"s1.size: ${s1.size}")
    println(s"s2: $s2")
    println(s"s2.size: ${s2.size}")
  }
  def mutableHashSet(): Unit = {
    val s1: mutable.HashSet[String] = mutable.HashSet("John", "Donna", "Ken", "Ken")
    val s2: mutable.HashSet[String] = s1 ++: mutable.HashSet("Elen", "Sara")
    println(s"s1: $s1")
    println(s"s1.size: ${s1.size}")
    println(s"s2: $s2")
    println(s"s2.size: ${s2.size}")
  }
  /**
   * This class implements immutable sets using a list-based data structure.
   * List set iterators and traversal methods visit elements in the order whey were first inserted.
   */
  def listSet(): Unit = {
    val s1: Set[String] = ListSet("John", "Adam", "Eve", "Donna", "Don")
    println(s"ListSet: $s1")
    val s2: Set[String] = Set("John", "Adam", "Eve", "Donna", "Don")
    println(s"HashSet: $s2")
    println(s1 == s2)
  }
  hashSet()
  mutableHashSet()
  listSet()
}

object SetOperations extends App {
  val s1 = Set("John", "Donna", "Ken")
  val s2 = Set("Ellen", "Sara", "Donna")

  performUnion(s1, s2)
  performIntersection(s1, s2)
  performDifference(s1, s2)

  def performUnion(x: Set[String], y: Set[String]): Unit = {
    val u = x union y
    println(s"x union y: $u")
  }
  def performIntersection(x: Set[String], y: Set[String]): Unit = {
    val i = x intersect y
    println(s"x intersection y: $i")
  }
  def performDifference(x: Set[String], y: Set[String]): Unit = {
    val d1 = x diff y
    val d2 = y diff x
    println(s"x difference y: $d1")
    println(s"y difference x: $d2")
  }
}
