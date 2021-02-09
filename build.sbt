// basics

name := "scala-logging"
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8",
  "-Ywarn-unused"
)
incOptions := incOptions.value.withLogRecompileOnMacro(false)
libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value)
initialCommands := """|import com.lightbend.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin

// OSGi

import com.typesafe.sbt.osgi.SbtOsgi
enablePlugins(SbtOsgi)
osgiSettings
OsgiKeys.bundleSymbolicName := "com.lightbend.scala-logging"
OsgiKeys.privatePackage := Seq()
OsgiKeys.exportPackage := Seq("com.lightbend.scalalogging*")

// publishing

organization := "com.lightbend"
licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
homepage := Some(url("https://github.com/lightbend/scala-logging"))
Test / publishArtifact := false
pomIncludeRepository := (_ => false)
scmInfo := Some(
  ScmInfo(url("https://github.com/lightbend/scala-logging"), "scm:git:git@github.com:lightbend/scala-logging.git")
)
developers := List(
  Developer(
    id = "hseeberger",
    name = "Heiko Seeberger",
    email = "",
    url = url("http://heikoseeberger.de")
  ),
  Developer(
    id = "analytically",
    name = "Mathias Bogaert",
    email = "",
    url = url("http://twitter.com/analytically")
  )
)
