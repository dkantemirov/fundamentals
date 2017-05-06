package fundamentals.scala.patterns.behavioral

/**
 * Педставляет действие.
 * Объект команды заключает в себе само действие и его параметры.
 *
 * The command pattern is used to encapsulate all the information needed to call
 * a method at a latter time. This information includes the method name, the object
 * that owns the method and values for the method parameters.
 * The command is useful to delay, sequence or log method calls.
 *
 * Применение: Запись макросов, Многоуровневая отмена операций (Undo),
 * Сети, Пулы потоков, Транзакции.
 */
object Command extends App {

  // In Scala, we can rely on by-name parameter to defer evaluation of any expression:
  object Invoker {
    private var history: Seq[() => Unit] = Seq.empty

    def invoke(command: => Unit) { // by-name parameter
      command
      history :+= command _
    }
  }

  Invoker.invoke(println("foo"))

  Invoker.invoke {
    println("bar 1")
    println("bar 2")
  }
}
