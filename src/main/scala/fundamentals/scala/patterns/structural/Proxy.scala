package fundamentals.scala.patterns.structural

/**
 * Объект, который является посредником между двумя другими объектами, и
 * который реализует/ограничивает доступ к объекту, к которому обращаются через него.
 */
object Proxy extends App {

  val p: IMath = new MathProxy

  /**
   * "Subject"
   */
  trait IMath {
    def add(x: Double, y: Double): Double

    def sub(x: Double, y: Double): Double

    def mul(x: Double, y: Double): Double

    def div(x: Double, y: Double): Double
  }

  /**
   * "Real Subject"
   */
  class Math extends IMath {
    def add(x: Double, y: Double): Double = x + y

    def sub(x: Double, y: Double): Double = x - y

    def mul(x: Double, y: Double): Double = x * y

    def div(x: Double, y: Double): Double = x / y
  }

  /**
   * "Proxy Object"
   */
  class MathProxy extends IMath {
    private lazy val math = new Math

    def add(x: Double, y: Double): Double = math.add(x, y)

    def sub(x: Double, y: Double): Double = math.sub(x, y)

    def mul(x: Double, y: Double): Double = math.mul(x, y)

    def div(x: Double, y: Double): Double = math.div(x, y)
  }
  println("4 + 2 = " + p.add(4, 2))
  println("4 - 2 = " + p.sub(4, 2))
  println("4 * 2 = " + p.mul(4, 2))
  println("4 / 2 = " + p.div(4, 2))
}
