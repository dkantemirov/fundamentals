package lang.scala.patterns.creational

/**
 * Класс, который может иметь только один экземпляр.
 */
object Singleton extends App {

  object Cat extends Runnable {
    def run() {
      // do nothing
    }
  }

  Cat.run()
}
