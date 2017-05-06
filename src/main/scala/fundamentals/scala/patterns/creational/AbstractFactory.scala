package fundamentals.scala.patterns.creational

/**
 * Класс, который представляет собой интерфейс для создания компонентов системы.
 * Предоставляет интерфейс для создания семейств взаимосвязанных или взаимозависимых
 * объектов, не специфицируя их конкретных классов.
 */
object AbstractFactory extends App {

  /**
   * Example of AbstractFactory pattern
   *
   * create OS Specific GUIWidget with same operation.
   *
   */

  trait Button {
    def paint: String
  }

  trait GUIFactory {
    def createButton: Button
  }

  class WinButton extends Button {
    def paint: String = "I'm a WinButton"
  }

  class OSXButton extends Button {
    def paint: String = "I'm a OSXButton"
  }

  class WinFactory extends GUIFactory {
    def createButton: Button = new WinButton
  }

  class OSXFactory extends GUIFactory {
    def createButton: Button = new OSXButton
  }

  class Application(factory: GUIFactory) {
    val button: Button = factory.createButton
    println(button.paint)
  }

  object ApplicationRunner {
    def main(argv: Array[String]) {
      new Application(createOsSpecificFactory(argv(0)))
    }

    def createOsSpecificFactory(os_type: String): GUIFactory = {
      os_type match {
        case "Win" => new WinFactory
        case "OSX" => new OSXFactory
      }
    }
  }

  ApplicationRunner.main(Array("Win"))
  ApplicationRunner.main(Array("OSX"))
}
