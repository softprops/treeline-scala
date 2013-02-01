package linden

case class Branch(name: String, children: Branch*)

case class Tree(unicode: Boolean = true) {
  def ascii = copy(unicode = false)

  def apply(branch: Branch, pad: String = ""): String =
    pad + show(branch, pad) + NL +
      branch.children.zipWithIndex.map {
        case (b @Branch(_, c @_*), i) =>
          val last = i == (branch.children.size - 1)
          val more = !c.isEmpty
          val padnext = pad + (if (last) " " else chr('│')) + " "
          val appnext = apply(b, padnext)
          pad +
            (if (last) chr('└') else chr('├')) + chr('─') +
            (if (more) chr('┬') else chr('─')) + " " +
            appnext.substring(padnext.length, appnext.length)
      }.mkString("")

  private def show(branch: Branch, pad: String) =
     branch.name
        .split(NL)
        .mkString(NL   +
                  pad  +
                  (if (branch.children.isEmpty) " " else chr('│')) +
                  " ")

  private def chr(c: Char) =
    if (unicode) c else Map(
      '│' -> '|',
      '└' -> '`',
      '├' -> '+',
      '─' -> '-',
      '┬' -> '-')(c)
}
