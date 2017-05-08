package fundamentals.scala.core

trait Interface1 {
  def foo(): Unit = System.out.println("Interface1's foo")
}
trait Interface2 {
  def foo(): Unit = System.out.println("Interface2's foo")
}
/**
 * In this case, resolve the conflict manually by using the super keyword within
 * the Diamond class to explicitly mention which method definition to use:
 */
class DiamondProblem extends Interface1 with Interface2 {
  override def foo(): Unit = super.foo()
}
object DiamondProblem extends App {
  new DiamondProblem().foo()
}

class BaseClass {
  def foo(): Unit = System.out.println("BaseClass's foo")
}
trait BaseInterface {
  def foo(): Unit = System.out.println("BaseInterface's foo")
}
/**
 * Different from Java code.
 * You need to override foo.
 */
class DiamondProblem2 extends BaseClass with BaseInterface {
  override def foo(): Unit = super.foo()
}

object DiamondProblem2 extends App {
  new DiamondProblem2().foo()
}

