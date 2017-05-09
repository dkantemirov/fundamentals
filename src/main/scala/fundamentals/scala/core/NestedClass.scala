package fundamentals.scala.core

import fundamentals.scala.core.NestedClass.Car.Tire

object NestedClass extends App {
  class Car(val year: Int)
  object Car {
    /**
     * Nested class
     */
    class Tire(val radius: Double)
  }

  val car = new Car(2015)
  val tire = new Tire(15.0)
  println(tire.radius)
}
