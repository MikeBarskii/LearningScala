package lectures.part3fp

object WhatAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // All Scala functions are objects!
}

// functional
trait MyFunction[A, B] {
  def apply(element: A): B
}

// OOP
class Action {
  def execute(element: Int): String = ???
}
