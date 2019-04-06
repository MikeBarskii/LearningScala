package part1basics

import scala.annotation.tailrec

object DefaultArgs {

  @tailrec
  def factorial(n: Int, acc: Int): Int = {
    if (n <= 1) acc
    else factorial(n - 1, n * acc)
  }

  factorial(10, 1) //often accumulator = 1

  @tailrec
  def factorialWithDefAccumulator(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else factorialWithDefAccumulator(n - 1, n * acc)
  }

  factorialWithDefAccumulator(10) // we don't have to set value of accumulator

  def savePicture(format: String = "jpg", width: Int, height: Int) = println("saving picture")

  //savePicture(800, 600) //compiler think that 800 is format parameter

  def savePictureDefault(format: String = "jpg", width: Int = 600, height: Int = 800) = println("saving picture")

  savePictureDefault(width = 1000) // we can set values of parameters by name
}
