package fundamentals.scala.core

trait Entity {
  def m: Int
}

trait Entity1 extends Entity {
  println(1)

  def m = 1
}

trait Entity2 extends Entity {
  println(2)

  def m = 2
}

trait Entity3 extends Entity {
  println(3)

  def m = 3
}

class EntityClass extends Entity1 with Entity2 with Entity3 {
  println(4)

  override def m: Int = super.m
}

trait EntityA {
  def m: Int
}

trait Entity1A extends EntityA {
  println(m)

  def m = 1
}

trait Entity2A extends EntityA {
  println(m)

  def m = 2
}

trait Entity3A extends EntityA {
  println(m)

  def m = 3
}

class EntityClassA extends Entity1A with Entity2A with Entity3A {
  println(m)

  override def m: Int = super.m
}

object DynamicBinding extends App {
  println(s"super call: ${new EntityClass().m}")
  println("-----------------------")
  println(s"A super call: ${new EntityClassA().m}")
}