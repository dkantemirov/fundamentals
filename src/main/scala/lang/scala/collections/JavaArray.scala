package lang.scala.collections

/**
 * Array is a special kind of collection in Scala. On the one hand, Scala arrays correspond
 * one-to-one to Java arrays. That is, a Scala array Array[Int] is represented as a Java int[],
 * an Array[Double] is represented as a Java double[] and a Array[String] is represented as a
 * Java String[]. But at the same time, Scala arrays offer much more than their Java analogues.
 * First, Scala arrays can be generic.
 */
object JavaArray extends App {
  def implicitInitialization(): Unit = {
    val arr = new Array[Int](5)
    arr(0) = 1
    for (i <- arr) println(i)
  }
  def explicitInitialization(): Unit = {
    val arr = Array(1, 2, 3, 4, 5)
    val empty1: Array[Int] = Array()
    val empty2: Array[Int] = Array.empty
    arr foreach println
  }
  implicitInitialization()
  explicitInitialization()
}
