package org.sbk.leet

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 851. Loud and Rich
 * https://leetcode.com/problems/loud-and-rich/
 */
class LoudAndRich {

  def loudAndRich(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
    val n = quiet.length
    val graph =  Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
    val revGraph = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
    val ans = Array.fill[Int](n)(0)

    def buildGraphs():Unit = {
      for (r <- richer) {
        val a = r(0)
        val b = r(1)
        graph(a) += b
        revGraph(b) += a
      }
    }

    def buildAns(): Unit = {
      for(i <- 0 until n) {
        buildAnsForI(i)
      }
    }

    def buildAnsForI(i: Int): Unit = {
      val r = findRicherThanI(i)
      if(r.isEmpty) {
        ans(i) = i
      } else {
        val m = r.map(a => quiet(a)).min
        val ai = quiet.indexOf(m)
        ans(i) = ai
      }
    }

    def findRicherThanI(i: Int): mutable.Set[Int] = {
      val richerThanI = mutable.Set[Int]()
      richerThanI += i
      bfs(richerThanI)

      @tailrec
      def bfs(r: mutable.Set[Int]): Unit = {
        if(r.nonEmpty) {
          val newRicher = r.flatMap(e => revGraph(e))
          richerThanI.addAll(newRicher)
          bfs(newRicher)
        }
      }

      richerThanI
    }

    buildGraphs()
    buildAns()

    ans
  }

}
