package lang.scala.patterns.structural

/**
 * Wrapper.
 * Класс, расширяющий функциональность другого класса без использования наследования.
 * The decorator pattern is used to extend functionality of some object, without affecting
 * other instances of the same class. Decorators provide a flexible alternative to subclassing.
 */
object Decorator extends App {

  /**
   * To achieve the same goal, Scala provides a direct way of overriding
   * interface methods, without binding to their concrete implementation
   * in place of declaration. Here’s how we can use abstract override modifier:
   */
  //  trait OutputStream {
  //    def write(b: Byte)
  //    def write(b: Array[Byte])
  //  }
  //
  //  class FileOutputStream(path: String) extends OutputStream { /* ... */ }
  //
  //  trait Buffering extends OutputStream {
  //    abstract override def write(b: Byte) {
  //      // ...
  //      super.write(buffer)
  //    }
  //  }
  //
  //  new FileOutputStream("foo.txt") with Buffering // with Filtering, ...

  trait Show {
    def show(): Unit = println(getClass)
  }

  class Name

  (new Name() with Show).show()
}
