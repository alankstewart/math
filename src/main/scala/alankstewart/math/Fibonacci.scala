package alankstewart.math

import scala.annotation.tailrec

/**
  * Created by alankstewart on 21/02/2016.
  */
object Fibonacci extends App {

  Range.inclusive(0, 35).foreach(i => println(fib(i)))

  def fib(n: Int) = {
    @tailrec
    def fibTail(n: Int, a: BigInt, b: BigInt): BigInt = n match {
      case 0 => a
      case 1 => b
      case _ => fibTail(n - 1, b, b + a)
    }
    fibTail(n, 0, 1)
  }
}
