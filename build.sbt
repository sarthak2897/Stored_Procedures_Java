ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "Scala_SP"
  )


libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.33"
