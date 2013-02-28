# treeline

A unicode tree renderer.
    
    ├─┬ ↑
    │ └── ⬆
    ├─┬ ⬆
    │ └── ↑
    └── ↑

## install

### using [ls](http://ls.implicit.ly/#installing)

    ls-install treeline

### using [sbt](http://www.scala-sbt.org/)

    libraryDepdendencies += "me.lessis" %% "treeline" % "0.1.0"

## usage

Treeline exposes two objects `Trees` and `Branches`. A `Tree` is made of one or more `Branches` and a `Branch` is just a name to display and an optional list of `Branches`.

```scala
import treeline._
println(Tree()(Branch("foo", Branch("bar", Branch("baz")), Branch("boom"))))
```

    foo
    ├─┬ bar
    │ └── baz
    └── boom

You can also render in ascii where unicode is not supported by calling the `ascii` method on a tree.

```scala
println(Tree().ascii(Branch("foo", Branch("bar", Branch("baz")), Branch("boom"))))
```

This will render

    foo
    +-- bar
    | `-- baz
    `-- boom

Doug Tangren (softprops) 2013
