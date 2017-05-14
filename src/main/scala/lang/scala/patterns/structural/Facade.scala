package lang.scala.patterns.structural

/**
 * Объект, который абстрагирует работу с несколькими классами, объединяя их в единое целое.
 * Позволяющий скрыть сложность системы путём сведения всех возможных внешних вызовов к одному
 * объекту, делегирующему их соответствующим объектам системы.
 */
object Facade extends App {

  trait SubSystemA {
    def methodA1()

    def methodA2()
  }

  trait SubSystemB {
    def methodB()
  }

  class ConcreteSubSystemA extends SubSystemA {
    override def methodA1() {
      println("System A")
    }

    override def methodA2() {
      println("System A")
    }
  }

  class ConcreteSubSystemB extends SubSystemB {
    override def methodB() {
      println("System B")
    }
  }

  class Facade extends SubSystemA with SubSystemB {
    val subsystemA = new ConcreteSubSystemA()
    val subsystemB = new ConcreteSubSystemB()

    override def methodA1() {
      subsystemA.methodA1()
    }

    override def methodA2() {
      subsystemA.methodA2()
    }

    override def methodB() {
      subsystemB.methodB()
    }
  }

  // Client
  object FacadeClient {
    var facade = new Facade()
    facade.methodA1()
    facade.methodA2()
    facade.methodB()
  }

}
