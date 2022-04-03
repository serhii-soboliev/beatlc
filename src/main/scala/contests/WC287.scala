package org.sbk.leet
package contests


class WC287 {
    def convertTime(current: String, correct: String): Int = {
        val s1 = current.split(":").map(_.toInt).reduceLeft((x,y) => x*60 +y)
        val s2 = correct.split(":").map(_.toInt).reduceLeft((x,y) => x*60 +y)
        var d: Int = s2 - s1
        var res = d / 60
        d = d % 60
        res += d / 15
        d = d % 15
        res += d / 5
        d = d % 5
        res += d
        res
    }

    def findWinners(matches: Array[Array[Int]]): List[List[Int]] = {
        import scala.collection.mutable
        import scala.collection.mutable.ArrayBuffer
        val winners = mutable.HashMap[Int, ArrayBuffer[Int]]()
        val loosers = mutable.HashMap[Int, ArrayBuffer[Int]]()

        for (matchh <- matches) {
            val w = matchh.head
            val l = matchh.last
            if(!winners.contains(w)) {
                winners(w) = ArrayBuffer[Int]()
            }
            winners(w) += l

            if(!loosers.contains(l)) {
                loosers(l) = ArrayBuffer[Int]()
            }
            loosers(l) += l
        }

        val onlyWinners = winners.keySet.diff(loosers.keySet).toList.sorted
        val oneTimeLoosers = loosers.filter { case (_, w) => w.length == 1 }.keys.toList.sorted
        List(onlyWinners, oneTimeLoosers)
    }

    def maximumCandies(candies: Array[Int], k: Long): Int = {
        var left: Long = 0
        var right: Long = 1_000_000_000
        while(left < right) {
            val mid: Long = (right + left + 1) / 2
            val sum: Long = candies.map(c => c / mid).sum
            if (k > sum) right = mid-1 else left = mid
        }
        left.toInt
    }
}

object WC287 {
    def main(args: Array[String]): Unit = {
        val c = new WC287()
        println(c.maximumCandies(Array(5,8,6), 3))
        println(c.maximumCandies(Array(2,5), 11))
    }
}

class Encrypter(_keys: Array[Char], _values: Array[String], _dictionary: Array[String]) {

    private val enc = (_keys zip _values).toMap

    def encrypt(word1: String): String = {
        word1.map(c => enc(c)).mkString
    }

    private val count = _dictionary.map(d => encrypt(d))
      .groupBy(identity)
      .view
      .mapValues(_.length)
      .toMap

    def decrypt(word2: String): Int = {
        count.getOrElse(word2, 0)
    }

}

object Encrypter {
    def main(args: Array[String]): Unit = {
        val e = new Encrypter(Array('a', 'b', 'c', 'd'),
            Array("ei", "zf", "ei", "am"),
            Array("abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"))
        println(e.encrypt("abcd"))
        println(e.decrypt("eizfeiam"))
    }
}
