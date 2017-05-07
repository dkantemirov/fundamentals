package fundamentals.scala.core

import java.io.IOException

object ExceptionHandling extends App {
  try throw new Exception catch { case e: Throwable => println(e) } finally println("fin")
}

object MultiCatchBlock extends App {
  try throw new Exception catch {
    case e: IOException => println(e)
    case e: Throwable => println(e)
  }
}