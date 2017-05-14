package lang.scala.patterns.behavioral

/**
 * Scala Option.
 *
 * Предотвращает нулевые указатели, предоставляя объект «по умолчанию».
 */
object NullObject extends App {

  trait Sound {
    def play()
  }

  class Music extends Sound {
    def play() {
      /* ... */
    }
  }

  object SoundSource {
    // Scala uses a similar approach, yet it provides
    // a predefined Option type, which can be used as
    // a placeholder for optional value:
    def getSound: Option[Sound] = None

    //if (available) Some(music) else None
  }

  for (sound <- SoundSource.getSound) {
    sound.play()
  }
}
