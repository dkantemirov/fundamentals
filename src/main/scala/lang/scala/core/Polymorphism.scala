package lang.scala.core

object Polymorphism

/**
 * Ad hoc polymorphism:
 * - Overloading Polymorphism.
 * - Coercion Polymorphism.
 * - Implicit class.
 */
object OverloadingPolymorphism extends App {
  def get(v: Int): Int = v

  def get(v: String): String = v

  println(s"get1=${get(5)};get2=${get("5")};")
}
object CoercionPolymorphism extends App {
  val v: Int = 1
  val d1: Double = v.asInstanceOf[Double]
  val d2: Double = v // coersion

  println(d2)
}
object ImplicitClass extends App {
  implicit class ExtendedString(str: String) {
    def virtualMethod: String = str
  }

  println("String".virtualMethod)
}

/**
 * Universal polymorphism:
 * 1. Inclusion Polymorphism (Subtype (or subclass) polymorphism).
 * 2. Parametric Polymorphism.
 */
object InclusionPolymorphism extends App {
  class T
  class S1 extends T
  class S2 extends T

  var t = new T
  val s1 = new S1
  val s2 = new S2

  t = s1
  t = s2

  println(t)
}
object ParametricPolymorphism extends App {
  // Use List for String type
  val sList: List[String] = List.empty
  val s2: String = (sList :+ "string 1" :+ "string 2").head

  // Use List for Integer type
  val iList: List[Int] = List.empty
  val i2: Int = (iList :+ 10 :+ 20).head

  println(s"s2=$s2;i2=$i2")
}