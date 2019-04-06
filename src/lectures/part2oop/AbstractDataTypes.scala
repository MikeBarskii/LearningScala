package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creatureType: String

    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    // also works without key word "override"
    def eat(): Unit = println("crunch, crunch")
  }

  //traits = interface
  trait Carnivore {
    def eat(animal: Animal): Unit

    val preferredMeal = "fresh meat"
  }

  trait ColdBloded

  class Crocodile extends Animal with Carnivore with ColdBloded {
    override val creatureType: String = "croc"

    override def eat(): Unit = println("Om-nom-nom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  /*
    Traits vs Abstract Class
    1. Traits don't have constructor parameters
    2. Extend 1 class, but multiple trait inheritance
    3. Traits = behaviour, Abstract Class = thing
   */

  /*
    Scala's Type Hierarchy
      scala.Any => scala.AnyRef(java.lang.Object) {String, List, Set} => scala.Null => scala.Nothing
      scala.Any => scala.AnyVal {Int, Unit, Boolean, Float} => scala.Nothing
   */
}
