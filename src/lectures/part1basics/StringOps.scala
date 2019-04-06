package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I'm learning Scala"

  println(str.charAt(2)) // return char at index 2 = "l"
  println(str.substring(7, 11)) // "I'm"
  println(str.split(" ")) // split string by regex to array of words
  println(str.startsWith("Hello")) //check that string starts from regex
  println(str.replace(" ", "-")) //replace all target chars to another chars
  println(str.toLowerCase) // all string to lower case
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2)) // take first 2 chars from string

  //Scala-specific: String interpolators

  //S-interpolators
  val name = "Davig"
  val age = 12
  val greeting = s"Hello, my name is $name and I'm $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  //F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute" //we can set format of string
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline") //similar s-interpolator but doesn't skip literals
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
