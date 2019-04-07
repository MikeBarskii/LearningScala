package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use type A in class definition
    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = Cat
      B = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]

  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) => return list of Animals

  // 2. List[Cat] doesn't extend List[Animal] = INVARIANCE
  class InvariantList[A]

  //val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] error

  // 3. CONTRAVARIANT
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded type
  class Cage[A <: Animal](animal: Animal)

  val cage = new Cage(new Dog)


}
