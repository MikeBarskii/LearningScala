package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = Person("Jim", 34)
  println(jim.age)

  // 2. sensible to string
  println(jim.toString) // Person(Jim,34)
  println(jim) // also Person(Jim,34)   println(instance) = println(instance.toString)

  // 3. equals and hashcode implemented out of the box
  val jim2 = Person("Jim", 34)
  println(jim == jim2) // true

  // 4. case classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3) // Person(Jim,45)

  // 5. case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // apply method does the same things that constructor. key words is not using

  // 6. case classes are serializable => useful for distributed systems

  // 7. case classes have extra patterns = CCs can be used in Pattern Matching

  case object UnitedKingdom {
    def name = "The UK of GB and NI"
  }

}
