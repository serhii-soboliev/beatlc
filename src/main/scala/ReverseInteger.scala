package org.sbk

object ReverseInteger {

  def reverse(x: Int): Int = {
    def internal(x: Int, d: scala.collection.mutable.ListBuffer[Int]): Unit = {
      if (x > 0) {
        d.+=(x % 10)
        internal(x / 10, d)
      }
    }

    val d = scala.collection.mutable.ListBuffer[Int]()
    internal(x.abs, d)
    var l: Long = 0
    var p = d.length - 1
    d.foreach(x => {
      l += x * scala.math.pow(10, p).toLong
      p -= 1
    })
    if (x < 0) l *= -1
    if (l > Int.MaxValue || l < Int.MinValue) 0
    else l.toInt
  }

  def reverse2(x: Int): Int = {

    import scala.collection.mutable._

    def _reverse(x: Int, acc: ArrayBuffer[Int]): ArrayBuffer[Int] = x match {
      case Int.MinValue | Int.MaxValue => acc.addOne(0)
      case x if x < 10 => acc.addOne(x)
      case _ => _reverse(x / 10, acc.addOne(x % 10))
    }

    val _ans = _reverse(Math.abs(x), new ArrayBuffer[Int]())

    val ans = _ans.foldLeft(0) { (r, c) => r * 10 + c }

    // If no overflow happened, than the last bit of answer and ArrayBuffer should match.
    if (ans % 10 == _ans.last)
      if (x < 0) ans * -1 else ans
    else 0
  }

  def main(args: Array[String]): Unit = {
    println(reverse(123))
    println(reverse2(120))
  }

}