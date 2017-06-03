import sbt._

object Dependencies {
  val akkaVersion = "2.5.1"
  val scalameterVersion = "0.8.2"
  val scalatestVersion = "3.0.1"

  object Akka {
    val groupID = "com.typesafe.akka"
    val actor = groupID %% "akka-actor" % akkaVersion
    val persistence = groupID %% "akka-persistence" % akkaVersion
    val stream = groupID %% "akka-stream" % akkaVersion
    val all = Seq(actor, persistence, stream)
  }

  val scalameter = "com.storm-enroute" %% "scalameter" % scalameterVersion

  val scalactic = "org.scalactic" %% "scalactic" % scalatestVersion
  val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion % "test"

  val all = Seq(
    scalameter,
    scalactic,
    scalatest
  ) ++ Akka.all
}