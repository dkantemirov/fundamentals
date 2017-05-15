import sbt._

object Dependencies {
  val akkaVersion = "2.5.1"
  val scalameterVersion = "0.8.2"

  object Akka {
    val groupID = "com.typesafe.akka"
    val actor = groupID %% "akka-actor" % akkaVersion
    val persistence = groupID %% "akka-persistence" % akkaVersion
    val all = Seq(actor, persistence)
  }

  val scalameter = "com.storm-enroute" %% "scalameter" % scalameterVersion

  val all = Seq(scalameter) ++ Akka.all
}