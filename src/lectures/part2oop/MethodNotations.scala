package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangoutWith(person: Person) = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person) = s"${this.name} in love with ${person.name}"

    def apply(): String = s"My name is $name and favorite movie is $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  /*
    infix notation = operator notation
    works only with methods with a single parameter
   */

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary.hangoutWith(tom))
  println(mary hangoutWith tom)

  println(mary + tom) // "+" is a method from class Person. Wow
  println(mary.+(tom)) // the same as the previous operation

  /*
    We're calling method apply() from class Person.
    If it's not exists we'll get error on compilation
   */
  println(mary())
}
