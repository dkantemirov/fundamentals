package fundamentals.scala.patterns.creational

abstract class Product

class ConcreateProductA extends Product

class ConcreateProductB extends Product

abstract class Creator {
  def factoryMethod: Product
}

class ConcreateCreatorA extends Creator {
  def factoryMethod: Product = new ConcreateProductA
}

class ConcreateCreatorB extends Creator {
  def factoryMethod: Product = new ConcreateProductB
}

/**
 * Также известен как Virtual Constructor.
 * Определяет интерфейс для создания объекта,
 * но оставляет подклассам решение о том, какой класс инстанцировать.
 *
 * 1. позволяет сделать код создания объектов более универсальным,
 * не привязываясь к конкретным классам (ConcreteProduct), а оперируя лишь
 * общим интерфейсом (Product);
 * 2. позволяет установить связь между параллельными иерархиями классов.
 */
object FactoryMethod extends App {
  Seq(new ConcreateCreatorA().factoryMethod, new ConcreateCreatorB().factoryMethod)
    .foreach(p => println(p.getClass))
}
