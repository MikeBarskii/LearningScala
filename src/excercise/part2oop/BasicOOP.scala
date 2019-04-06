package excercise.part2oop

object BasicOOP extends App {
  val counter = new Counter(3)
  counter.inc(5)
  counter.inc.inc.inc.print //possible option
}

class Counter(val count: Int) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }

  def dec = {
    println("decrementing")
    new Counter(count + 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}