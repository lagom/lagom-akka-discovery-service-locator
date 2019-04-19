/*
 * Copyright (C) 2018-2019 Lightbend Inc. <https://www.lightbend.com>
 */

import sbt._

object Dependencies {

  object Versions {
    val Lagom = sys.props.getOrElse("lagom.build.version", "1.5.0")
    val Akka = "2.5.22"
  }

  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.7" % Test

  val serviceLocatorCore = Seq(
    "com.typesafe.akka" %% "akka-discovery" % Versions.Akka,
    "org.slf4j" % "slf4j-api" % "1.7.26" % Provided,

    scalaTest,
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Test
  )

  val serviceLocatorJavadsl = Seq(
    "com.lightbend.lagom" %% "lagom-javadsl-client" % Versions.Lagom % Provided,
    
    // test dependencies
    scalaTest,
    "com.lightbend.lagom" %% "lagom-javadsl-testkit" % Versions.Lagom % Test
  )

  val serviceLocatorScaladsl = Seq(
    "com.lightbend.lagom" %% "lagom-scaladsl-client" % Versions.Lagom % Provided,

    // test dependencies
    scalaTest,
    "com.softwaremill.macwire" %% "macros" % "2.3.0" % Test,
    "com.lightbend.lagom" %% "lagom-scaladsl-testkit" % Versions.Lagom % Test
  )

}
