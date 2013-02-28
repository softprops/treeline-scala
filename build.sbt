organization := "me.lessis"

name := "treeline"

version := "0.1.0"

description := "Renders nested branches of trees in unicode and ascii"

homepage :=
  Some(url("https://github.com/softprops/treeline/"))

scalacOptions += Opts.compile.deprecation

publishTo := Some(Opts.resolver.sonatypeStaging)

licenses <<= version(v =>
      Seq("MIT" ->
          url("https://github.com/softprops/treeline/blob/%s/LICENSE" format v)))

publishArtifact in Test := false

publishMavenStyle := true

pomExtra := (
  <scm>
    <url>git@github.com:softprops/treeline.git</url>
    <connection>scm:git:git@github.com:softprops/treeline.git</connection>
  </scm>
  <developers>
    <developer>
      <id>softprops</id>
      <name>Doug Tangren</name>
      <url>http://github.com/softprops</url>
    </developer>
  </developers>)

seq(lsSettings:_*)

LsKeys.tags in LsKeys.lsync := Seq("tree", "unicode")
