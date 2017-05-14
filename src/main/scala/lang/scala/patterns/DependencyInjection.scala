package lang.scala.patterns

object DependencyInjection extends App {

  trait NameProviderComponent {
    val nameProvider: NameProvider

    trait NameProvider {
      def getName: String
    }

  }

  trait SayHelloComponent {
    val sayHelloService: SayHelloService

    trait SayHelloService {
      def sayHello(): Unit
    }

  }

  trait NameProviderComponentImpl extends NameProviderComponent {

    class NameProviderImpl extends NameProvider {
      def getName: String = "World"
    }

  }

  trait SayHelloComponentImpl extends SayHelloComponent {
    this: NameProviderComponent =>

    class SayHelloServiceImpl extends SayHelloService {
      def sayHello(): Unit = println("Hello, " + nameProvider.getName + "!")
    }

  }

  object ComponentRegistry
      extends SayHelloComponentImpl
      with NameProviderComponentImpl {
    val nameProvider = new NameProviderImpl
    val sayHelloService = new SayHelloServiceImpl
  }

  println(ComponentRegistry.nameProvider.getName)
}
