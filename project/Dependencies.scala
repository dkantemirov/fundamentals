import sbt._

object Dependencies {
  val akkaVersion = "2.5.2"
  val akkaHttpVersion = "10.0.7"
  val akkaHttpSprayVersion = "10.0.7"
  val scalameterVersion = "0.8.2"
  val scalatestVersion = "3.0.1"

  object Akka {
    val groupID = "com.typesafe.akka"
    val actor = groupID %% "akka-actor" % akkaVersion
    val http = groupID %% "akka-http" % akkaHttpVersion
    val httpTestKit = groupID %% "akka-http-testkit" % akkaHttpVersion % Test
    val httpSprayJson = groupID %% "akka-http-spray-json" % akkaHttpSprayVersion
    val persistence = groupID %% "akka-persistence" % akkaVersion
    val stream = groupID %% "akka-stream" % akkaVersion
    val all = Seq(actor, http, httpTestKit, httpSprayJson, persistence, stream)
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