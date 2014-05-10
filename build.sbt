organization := "me.lessis"

name := "treeline"

version := "0.1.0"

description := "Renders nested branches of trees in unicode and ascii"

homepage :=
  Some(url("https://github.com/softprops/%s/".format(name.value)))

scalacOptions += Opts.compile.deprecation

publishTo := Some(Opts.resolver.sonatypeStaging)

licenses <<= version(v =>
      Seq("MIT" ->
          url("https://github.com/softprops/treeline/blob/%s/LICENSE" format v)))

crossScalaVersions :=
      Seq("2.9.3", "2.10.4", "2.11.0")

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

credentials += Credentials("Sonatype Nexus Repository Manager",
                           "oss.sonatype.org",
                           "your-sonatype-username",
                           "your-sonatype-password")
