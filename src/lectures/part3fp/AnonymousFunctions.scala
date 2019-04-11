package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous function - lambda
  val doubler: Int => Int = (x: Int) => x * 2

  val easyDoubler = (x: Int) => x * 2

  val anotherDoubler: Int => Int = x => x * 2

  // multiple params in lambda
  val adder: (Int, Int) => Int = (a, b) => a + b

  val easyAdder = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething = () => 3
  val justDoSomething1: () => Int = () => 3

  // lambda functions have to be called with parenthesis
  println(justDoSomething) // return lectures.part3fp.AnonymousFunctions$$$Lambda$12/89387388@704d6e83
  println(justDoSomething()) // return value = 3

  // curly braces
  val stringToInt = { str: String =>
    str.toInt
  }

  // syntactic sugar
  val increment: Int => Int = (x: Int) => x + 1
  val niceIncrement: Int => Int = _ + 1

  // multiple sugar
  val multipleSugar: (Int, Int) => Int = (a, b) => a + b
  val niceMultipleSugar: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
    1.  MyList: replace all FunctionX calls with lambdas
    2.  Rewrite the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y

  println(superAdd(4)(3)) // 7
}
