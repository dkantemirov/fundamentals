import com.lightbend.sbt.JavaFormatterPlugin.JavaFormatterKeys
import sbt.Keys._
import sbt._

object CommonSettings {
  lazy val commonSettings: Seq[Def.Setting[_]] = Seq(
    name := "lang",
    organization := "ru.kantemirov.lang",
    version := "0.1.1-SNAPSHOT",
    scalaVersion := "2.12.2",
    libraryDependencies ++= Dependencies.all,
    testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
    JavaFormatterKeys.javaFormattingSettingsFilename := "eclipse-java-google-style.xml",
    parallelExecution in Test := false
  )
}