package excercise.part2oop

abstract class MyList {

  /*
    head = first of element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with added element
    toString => a string representation of the list
 */

  def head(): Int

  def tail(): MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements(): String

  override def toString: String = "[" + printElements() + "]"
}

object EmptyList extends MyList {
  override def head(): Int = throw new NoSuchElementException

  override def tail(): MyList = throw new NoSuchElementException

  override def isEmpty(): Boolean = true

  override def add(element: Int): MyList = new ConsList(element, this)

  def printElements(): String = ""
}

class ConsList(h: Int, t: MyList) extends MyList {
  override def head(): Int = h

  override def tail(): MyList = t

  override def isEmpty(): Boolean = false

  override def add(element: Int): MyList = new ConsList(element, this)

  def printElements(): String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTests extends App {
  val list = new ConsList(1, EmptyList)
  println(list.add(2).add(3).add(7).toString)
}