package treeline

import org.scalacheck._

object RenderingSpecification
extends Properties("rendering") {
  import Prop._
  def genTree = for {
    root    <- Gen.alphaStr
    branch0 <- Gen.alphaStr
    branch1 <- Gen.alphaStr
  } yield (root, branch0, branch1)

  property("render unicode trees") = forAll(genTree) {
    case (root, b0, b1) =>
      val res = Tree()(Branch(root, Branch(b0), Branch(b1)))
      res =? """%s
             |├── %s
             |└── %s
             |""".stripMargin.format(root, b0, b1)
  }

  property("render ascii trees") = forAll(genTree) {
    case (root, b0, b1) =>
      val res = Tree().ascii(Branch(root, Branch(b0), Branch(b1)))
      res =? """%s
             |+-- %s
             |`-- %s
             |""".stripMargin.format(root, b0, b1)
  }
}
