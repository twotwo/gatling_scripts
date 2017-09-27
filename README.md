# gatling_scripts
Scala & Gatling Start Ups

## Reference
* [Scala](http://wiki.li3huo.com/Scala)
* [Gatling](http://wiki.li3huo.com/Gatling)


## First Project
[Scala_Test_Tutorial](http://wiki.li3huo.com/Scala#Scala_Test_Tutorial)

    ➜  gatling_scripts git:(master) ✗ sbt new scala/scala-seed.g8 
    [info] Set current project to gatling_scripts (in build file:/opt/local/ide/git_storage/github/gatling_scripts/)

    A minimal Scala project. 

    name [Scala Seed Project]: ScalaTestTutorial

    Template applied in ./scalatesttutorial

    ➜  gatling_scripts git:(master) ✗ cd scalatesttutorial; sbt run test
    [info] Loading project definition from /opt/local/ide/git_storage/github/gatling_scripts/scalatesttutorial/project
    [info] Set current project to Hello (in build file:/opt/local/ide/git_storage/github/gatling_scripts/scalatesttutorial/)
    [info] Running example.Hello 
    hello
    [success] Total time: 0 s, completed Sep 27, 2017 3:48:56 PM
    ...
    [success] Total time: 1 s, completed Sep 27, 2017 3:48:56 PM

## Scala Basics
[基本语法](http://twitter.github.io/scala_school/zh_cn/basics.html) Values, functions, classes, methods, inheritance, try-catch-finally. Expression-oriented programming

### Functions: Partial application

    scala> def adder(m: Int, n: Int) = m + n
    adder: (m: Int, n: Int)Int

    scala> val add2 = adder(2, _:Int)
    add2: Int => Int = $$Lambda$3023/332270394@769e1869

    scala> add2(3)
    res5: Int = 5

### Functions: Variable length arguments

    scala> def capitalizeAll(args: String*) = {
         |   args.map { arg =>
         |     arg.capitalize
         |   }
         | }
    capitalizeAll: (args: String*)Seq[String]

    scala> capitalizeAll("rarity", "applejack", "wahaha")
    res6: Seq[String] = ArrayBuffer(Rarity, Applejack, Wahaha)

### Classes: Functions vs Methods

    scala> class C {
         |   var acc = 0
         |   def minc = { acc += 1 }
         |   val finc = { () => acc += 1 }
         | }
    defined class C

    scala> val c = new C
    c: C = C@1af1bd6

    scala> c.minc // calls c.minc()

    scala> c.finc // returns the function as a value:
    res2: () => Unit = <function0>


