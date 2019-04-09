package excercise.part2oop

import excercise.part2oop.GenericEx.{MyPredicate, MyTransformer}

abstract class MyList[+A] {

  /*
    head = first of element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with added element
    toString => a string representation of the list
 */

  def head(): A

  def tail(): MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements(): String

  override def toString: String = "[" + printElements() + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object EmptyList extends MyList[Nothing] {
  override def head(): Nothing = throw new NoSuchElementException

  override def tail(): MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new ConsList(element, this)

  def printElements(): String = ""

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class ConsList[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head(): A = h

  override def tail(): MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new ConsList(element, this)

  def printElements(): String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new ConsList(transformer.transform(h), t.map(transformer))
  }

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new ConsList(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = new ConsList[B](h, t ++ list)
}

object ConsList {

}

object ListTests extends App {
  val listOfIntegers: MyList[Int] = new ConsList(1, new ConsList(2, new ConsList(3, EmptyList)))
  val listOfStrings: MyList[String] = new ConsList("Hello", new ConsList("Scala", EmptyList))

  println(listOfIntegers) // [1 2 3]
  println(listOfStrings) // [Hello Scala]

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element + 2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).toString)

  val anotherListOfIntegers: MyList[Int] = new ConsList(6, new ConsList(4, new ConsList(5, EmptyList)))
  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(element: Int): MyList[Int] = new ConsList(element, new ConsList(element + 1, EmptyList))
  }).toString)

  val cloneListOfIntegers: MyList[Int] = new ConsList(1, new ConsList(2, new ConsList(3, EmptyList)))
  println(listOfIntegers == cloneListOfIntegers) // true
}