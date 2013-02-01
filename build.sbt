organization := "me.lessis"

name := "linden"

version := "0.1.0-SNAPSHOT"

description := "Renders nested tree branches in unicode and ascii"

homepage :=
  Some(url("https://github.com/softprops/linden/"))

scalacOptions += Opts.compile.deprecation

publishTo := Some(Opts.resolver.sonatypeStaging)

licenses <<= version(v =>
      Seq("MIT" ->
          url("https://github.com/softprops/linden/blob/%s/LICENSE" format v)))

publishArtifact in Test := false

publishMavenStyle := true

pomExtra := (
  <scm>
    <url>git@github.com:softprops/linden.git</url>
    <connection>scm:git:git@github.com:softprops/linden.git</connection>
  </scm>
  <developers>
    <developer>
      <id>softprops</id>
      <name>Doug Tangren</name>
      <url>http://github.com/softprops</url>
    </developer>
  </developers>)

