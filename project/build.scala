object Build extends sbt.Build {
  import sbt._
  lazy val root =
    Project("root", file("."))
      .dependsOn(scalacheck % "test->test")

  lazy val scalacheck = RootProject(
    uri("git://github.com/n8han/scalacheck.git#3aad8be")
  )
}
