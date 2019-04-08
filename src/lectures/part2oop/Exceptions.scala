package lectures.part2oop

object Exceptions extends App {
  val x: String = null

  // println(x.length) NPE

  // throw new NullPointerException - expression to throw exception

  // val aWeirdValue = throw new NullPointerException // type of this value - Nothing

  // tree of Errors and Exceptions is similar to Java

  // catching exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

  val potentialFail = try { //type of this value - AnyVal: because try block returns Int and catch block returns Unit
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught a Runtime Exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    println("finally")
  }

  // defining own Exception
  class MyException extends Exception

  val exception = new MyException
  // throw exception - throwing my own exception

  /*
    1.  Crash program with an OutOfMemoryError
    2.  Crash with SOError
    3.  Pocket calculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */
}
