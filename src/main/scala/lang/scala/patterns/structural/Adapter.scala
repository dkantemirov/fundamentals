package lang.scala.patterns.structural

import sun.util.logging.PlatformLogger.Level
import sun.util.logging.PlatformLogger.Level._

/**
 * Wrapper.
 * Объект, обеспечивающий взаимодействие двух других объектов,
 * один из которых использует, а другой предоставляет несовместимый с первым интерфейс.
 */
object Adapter extends App {

  val log: Log = new Logger()

  // In Scala, we have a built-in concept of interface adapters, expressed as implicit classes:
  trait Log {
    def warning(message: String)

    def error(message: String)
  }

  implicit class LoggerToLogAdapter(logger: Logger) extends Log {
    def warning(message: String) {
      logger.log(WARNING, message)
    }

    def error(message: String) {
      logger.log(SEVERE, message)
    }
  }

  final class Logger {
    def log(level: Level, message: String) {
      /* ... */
    }
  }
}
