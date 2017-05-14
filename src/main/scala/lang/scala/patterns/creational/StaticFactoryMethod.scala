package lang.scala.patterns.creational

/**
 * Также известен как Virtual Constructor.
 * Определяет интерфейс для создания объекта,
 * но оставляет подклассам решение о том, какой класс инстанцировать.
 */
object StaticFactoryMethod extends App {

  trait Animal

  private class Dog extends Animal

  private class Cat extends Animal

  object Animal {
    def apply(kind: String): Animal = kind match {
      case "dog" => new Dog()
      case "cat" => new Cat()
    }
  }

  Animal("dog")
}

