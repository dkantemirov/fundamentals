package fundamentals.scala.patterns.behavioral

/**
 * Цепочка обязанностей.
 *
 * Предназначен для организации в системе уровней ответственности.
 *
 * Шаблон рекомендован для использования в условиях:
 * в разрабатываемой системе имеется группа объектов, которые могут
 * обрабатывать сообщения определенного типа;
 * все сообщения должны быть обработаны хотя бы одним объектом системы;
 * сообщения в системе обрабатываются по схеме «обработай сам либо
 * перешли другому», то есть одни сообщения обрабатываются на том уровне,
 * где они получены, а другие пересылаются объектам иного уровня.
 */
object ChainOfResponsibility extends App {

  type EventHandler = PartialFunction[Event, Unit]
  val defaultHandler: EventHandler = PartialFunction(_ => ())
  val keyboardHandler: EventHandler = {
    case Event("keyboard") => /* ... */
  }

  def mouseHandler(delay: Int): EventHandler = {
    case Event("mouse") => /* ... */
  }

  case class Event(source: String)

  keyboardHandler.orElse(mouseHandler(100)).orElse(defaultHandler)
}
