package excercise.part2oop

object WhatAFunctionEx extends App {

  /*
    1. A function which takes 2 strings and concatenate them
    2. Transform MyPredicate and MyTransformer into Function types
    3. Define a function which takes an int and returns another function which takes an int and returns an int
 */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(string1: String, string2: String): String = string1 + string2
  }

  println(concatenator("Hello ", "Scala")) // Hello Scala

  def superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  // now adder3 is a Function[Int, Int]
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(4)(3)) // curried function
}
