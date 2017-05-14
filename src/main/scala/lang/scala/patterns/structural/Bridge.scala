package lang.scala.patterns.structural

/**
 * Структура, позволяющая изменять интерфейс обращения и интерфейс
 * реализации класса независимо.
 * Архитектура Java AWT полностью основана на этом шаблоне —
 * иерархия java.awt.xxx для хэндлов и sun.awt.xxx для реализаций.
 */
object Bridge extends App {

  // http://en.wikipedia.org/wiki/Bridge_pattern

  trait DrawingAPI {
    def drawCircle(x: Double, y: Double, radius: Double)
  }

  abstract class Shape(drawingAPI: DrawingAPI) {
    def draw()

    def resizeByPercentage(pct: Double)
  }

  class DrawingAPI1 extends DrawingAPI {
    override def drawCircle(x: Double, y: Double, radius: Double): Unit = {
      printf("API1.circle at %f:%f radius %f\n", x, y, radius)
    }
  }

  class DrawingAPI2 extends DrawingAPI {
    override def drawCircle(x: Double, y: Double, radius: Double): Unit = {
      printf("API2.circle at %f:%f radius %f\n", x, y, radius)
    }
  }

  class CircleShape(x: Double, y: Double, radius: Double, drawingAPI: DrawingAPI)
      extends Shape(drawingAPI) {
    var _x: Double = x
    var _y: Double = y
    var _radius: Double = radius

    override def draw(): Unit = drawingAPI.drawCircle(_x, _y, _radius)

    override def resizeByPercentage(pct: Double): Unit = _radius *= pct
  }

  object BridgeSample {
    def main(args: Array[String]): Unit = {
      var shapes = List(
        new CircleShape(1, 2, 3, new DrawingAPI1()),
        new CircleShape(5, 7, 11, new DrawingAPI2())
      )

      shapes.foreach((s: Shape) => {
        s.resizeByPercentage(2.5)
        s.draw()
      })
    }
  }

  BridgeSample.main(Array())
}
