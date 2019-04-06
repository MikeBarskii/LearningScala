package excercise.part2oop

object MethodNotationsEx extends App {

  /*
    1. Overload the + operator
       mary + "the rockstar" => new Person "Mary (the rockstar)"

    2. Add an age to the Person class
       Add a unary operator => new Person with the age + 1
       +mary => mary with the age incremented

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnsScala method, calls the learns method with "Scala".
       Use it in postfix notation

    4. Overload the apply method to receive number and return a string
       many.apply(2) => "Mary watched Inception 2 times"
 */

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def +(nickname: String) = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_+() = new Person(name, favoriteMovie, age + 1)

    def learns(lesson: String) = s"$name learns $lesson"

    def learnsScala(): String = this learns "Scala"

    def apply(n: Int) = s"$name watched $favoriteMovie $n times"

    def apply(): String = s"My name is $name and my favorite movie is $favoriteMovie"
  }

  val mary = new Person("Mary", "Fight Club")
  println((mary + "the Rockstar").apply())
  println((+mary).age)
  println(mary learnsScala())
  println(mary(10))
}
