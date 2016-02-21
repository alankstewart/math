package alankstewart.math

import scala.annotation.tailrec

/**
  * Created by alankstewart on 21/02/2016.
  */
object Fibonacci extends App {

  Range.inclusive(0, 35).foreach(i => println(i + ": " + fibonacci(i)))

  @tailrec
  def fibonacci(n: Int, a: BigInt = 0, b: BigInt = 1): BigInt = n match {
    case 0 => a
    case 1 => b
    case _ => fibonacci(n - 1, b, a + b)
  }
}
