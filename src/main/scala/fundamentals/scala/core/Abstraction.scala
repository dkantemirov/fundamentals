package fundamentals.scala.core

abstract class Abstraction {
  val i = 1

  def count: Int
}

class AbstractionImpl extends Abstraction {
  def count: Int = i
}

