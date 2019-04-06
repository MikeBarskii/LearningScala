package lectures.part2oop

object Objects extends App {

  // Scala does not have class-level functionality ("static")
  object Person { //type + it's only instance
    // "static"/"class" - level functionality
    val N_EYES = 2

    def canFly = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  //class Person and object Person are COMPANIONS: the same scope and name

  // Scala object = singleton instance
  val mary = Person
  val alex = Person
  println(mary == alex) //true

  val mory = new Person("Mory")
  val alox = new Person("Alox")
  println(mory == alox) //false

  //Looks like a constructor but actually it's apply method in Person singleton object
  val bobbie = Person(mory, alox)

  /* Scala Applications = Scala object with
      def main(args: Array[String]): Unit
  */
}
