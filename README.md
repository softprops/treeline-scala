# linden

A unicode tree renderer.

## usage

Linden exposes two objects `Trees` and `Branches`. A `Tree` is made of one or more `Branches` and a `Branch` is just a name to display and an optional list of `Branches`.

```scala
import boxelder._
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
