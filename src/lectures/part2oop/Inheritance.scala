package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val creatureType = "wild"

    def eat(): Unit = println("Om-nom-nom")
  }

  class Cat extends Animal // Animal - superclass of Cat. Cat - subclass of Animal

  /*
    As in Java, Scala doesn't support multiple inheritance
    Scala has almost the same access modifiers: private, protected, public (non-modifier)
   */

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // we need define to call a parent constructor
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding val and def
  class Dog extends Animal {
    override val creatureType: String = "domestic"

    override def eat(): Unit = println("crunch, crunch")
  }

  new Cat().eat() // was not overrode Output: "Om-nom-nom"
  new Dog().eat() // was overrode Output: "crunch, crunch"

  // we can override val in constructor as a class parameter
  class Snake(override val creatureType: String) extends Animal

  // another type to override val from parent
  class Cow(val cowType: String) extends Animal {
    override val creatureType: String = cowType
  }

  // type substitution - polymorphism
  val unknownAnimal: Animal = new Dog
  unknownAnimal.eat() // "crunch, crunch"

  // super
  class Fox extends Animal {
    override def eat(): Unit = {
      super.eat()
      println("What does the fox say?")
    }
  }

  val fox = new Fox
  fox.eat() // "Om-nom-nom \n What does the fox say?"

  /*
    Prevent overriding.
      1. "final" word to prevent overriding on val or def
      2. "final" word on the entire class => prevent class to be extended
      3. "sealed" word on the entire class => extend classes in THIS FILE, prevent extension in other file
   */
  sealed class Car {
    final val numberOfWheels = 4
  }

}
