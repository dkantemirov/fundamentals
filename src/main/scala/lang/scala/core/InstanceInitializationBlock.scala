package lang.scala.core

class InstanceInitializationBlock {
  var i = 1
  i = 2
  println(i)
}

object InstanceInitializationBlock extends App {
  println("init")
  new InstanceInitializationBlock
}
