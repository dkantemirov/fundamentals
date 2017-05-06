package fundamentals.scala.patterns.behavioral

/**
 * Предназначен для определения семейства алгоритмов, инкапсуляции
 * каждого из них и обеспечения их взаимозаменяемости.
 *
 * The pattern is handy when we need to select an algorithm at runtime.
 */
object Strategy extends App {
  // Because Scala offers first-class
  // functions, we can use them to express the same concept directly:
  type Strategy = (Int, Int) => Int
  val add: Strategy = _ + _
  val multiply: Strategy = _ * _

  class Context(computer: Strategy) {
    def use(a: Int, b: Int) {
      computer(a, b)
    }
  }

  new Context(multiply).use(2, 3)
}
