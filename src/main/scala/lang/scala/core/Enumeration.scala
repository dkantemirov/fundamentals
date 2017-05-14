package lang.scala.core

trait Severity

object Severity {

  case object LOW extends Severity

  case object MEDIUM extends Severity

  case object HIGH extends Severity

  case object URGENT extends Severity

}

/**
 * Idiomatic Scala way is using case classes and case objects.
 */
object Enumeration extends App {
  val defaultSeverity: Severity = Severity.MEDIUM
  val i: Int = defaultSeverity match {
    case Severity.LOW => 30
    case Severity.MEDIUM => 15
    case Severity.HIGH => 7
    case Severity.URGENT => 1
    case _ => 0
  }
  println(i)
}

/**
 * One big difference is that Enumerations come with support for instantiating
 * them from some name String.
 */
object JavaLikeEnumeration extends App {
  object Currency extends scala.Enumeration {
    val GBP = Value("GBP")
    val EUR = Value("EUR") //etc.
  }
  val ccy = Currency.withName("EUR")
  println(ccy)
}
