name := "regression-tester-poc-1"

version := "0.1.0-SNAPSHOT"

organization := "com.anglowide"

scalaVersion := "2.12.0"

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"
)

val specs2 = "org.specs2" %% "specs2-core" % "3.8.6" % "test" 

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  specs2
)

//resourceDirectory in Test := baseDirectory.value / "resources"

scalacOptions in Test ++= Seq("-Yrangepos")

