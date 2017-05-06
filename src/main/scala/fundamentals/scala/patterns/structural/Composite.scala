package fundamentals.scala.patterns.structural

/**
 * Компоновщик.
 * Объект, который объединяет в себе объекты, подобные ему самому.
 * Объединяющий объекты в древовидную структуру для представления
 * иерархии от частного к целому.
 */
object Composite extends App {

  // http://en.wikipedia.org/wiki/Composite_pattern

  trait Graphic {
    def print(): Unit
  }

  class CompositeGraphic extends Graphic {
    private var mChildGraphics = List[Graphic]()

    override def print(): Unit = {
      println("(")
      mChildGraphics.foreach((g: Graphic) => {
        g.print()
      })
      println(")")
    }

    def add(graphic: Graphic): Unit = {
      mChildGraphics = graphic :: mChildGraphics
    }

    def remove(graphic: Graphic): Unit = {
      mChildGraphics = mChildGraphics.filterNot(_ == graphic)
    }
  }

  class Ellipse extends Graphic {
    override def print(): Unit = {
      println("Ellipse")
    }
  }

  object CompositeSample {
    def main(args: Array[String]): Unit = {
      val ellipse1 = new Ellipse
      val ellipse2 = new Ellipse
      val ellipse3 = new Ellipse
      val ellipse4 = new Ellipse

      var graphic = new CompositeGraphic
      var graphic1 = new CompositeGraphic
      var graphic2 = new CompositeGraphic

      graphic1.add(ellipse1)
      graphic1.add(ellipse2)
      graphic1.add(ellipse3)

      graphic2.add(ellipse4)

      graphic.add(graphic1)
      graphic.add(graphic2)

      graphic.print()
    }
  }

  CompositeSample.main(Array())
}
