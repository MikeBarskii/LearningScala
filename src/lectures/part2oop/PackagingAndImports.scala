package lectures.part2oop

// name aliasing
import lectures.part2oop.AbstractDataTypes.{Animal => Anim}

object PackagingAndImports extends App {

  //package members are accessible by their simple name
  val snake = new Anim {
    override val creatureType: String = "shhh"

    override def eat(): Unit = println("omnonmnon")
  }

  // import the package - add import if you want to work with class from other package

  // method from package object
  sayHello()

  // import 2 classes from 1 package: import package_name.{Class1, Class2}
  // import all class from package: import package_name._

  /*
    Default imports:
      java.lang - String, Object, Exception
      scala - Int, Nothing, Function
      scala.Predef - println, ???
   */

}
