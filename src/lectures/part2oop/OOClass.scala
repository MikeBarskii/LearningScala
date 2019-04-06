package lectures.part2oop

object OOClass extends App {
  val person = new Person("John", 27)
  //println(person.age) //age is a class parameter, but not a class member

  val personA = new PersonA("John", 27)
  println(personA.age)
  println(personA.x)
  personA.greet("Daniel")
}

class Person(name: String, age: Int) //constructor

// class parameters and class fields are too different things

class PersonA(name: String, val age: Int) {
  /*
    Implementation(body) of this class
    At every instantiation of this class this whole block code will be evaluated
   */
  val x = 2
  println(1 + 3)

  //the name of this class will greet the name passed to the method
  def greet(name: String) = println(s"$this.name says: Hi, $name")

  //overloading
  def greet() = println(s"Hi, my name is $name")

  /*
    Compiler won't know which method it should call. This is not overloading
    def greet(): Int = 42
   */

  /*
    Implementation of Multiple constructor. And we can create main constructor with defaul values:
    class PersonA(name: String, val age: Int = 0)
   */
  def this(name: String) = this(name, 0)
}