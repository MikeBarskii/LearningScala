package part1basics

object CBVvsCBN extends App {

  def printByValue(x: Long) = {
    println("by value " + x)
    println("by value " + x)
  }

  def printByName(x: => Long) = {
    println("by name " + x)
    println("by name " + x)
  }

  printByValue(System.nanoTime())
  printByName(System.nanoTime())
}
