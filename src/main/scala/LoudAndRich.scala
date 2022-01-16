package org.sbk.leet

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 851. Loud and Rich
 * https://leetcode.com/problems/loud-and-rich/
 */
class LoudAndRich {

  def loudAndRichTopologicalSort(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
    val n = quiet.length
    val graph = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
    val indegree = Array.fill[Int](n)(0)
    val queue = mutable.Queue[Int]()
    val ans = (0 until n).toArray

    def buildGraphs():Unit = {
      richer foreach(
          r => {
            graph(r(0)) += r(1)
            indegree(r(1)) += 1
          }
        )
    }

    def initQueue(): Unit = {
      for(i <- 0 until n) {
        if(indegree(i) == 0) {
          queue += i
        }
      }
    }

    def isMoreQuiet(a: Int, b: Int): Boolean = {
      quiet(ans(a)) > quiet(ans(b))
    }

    def topSort() : Unit = {
      while(queue.nonEmpty)  {
        val ele = queue.dequeue()
        for (neighbor <- graph(ele)) {
          if(isMoreQuiet(neighbor, ele)) {
            ans(neighbor) = ans(ele)
          }
          indegree(neighbor) -= 1
          if(indegree(neighbor) == 0) {
            queue += neighbor
          }
        }
      }
    }

    buildGraphs()
    initQueue()
    topSort()
    ans
  }

  def loudAndRichBFS(richer: Array[Array[Int]], quiet: Array[Int]): Array[Int] = {
    val n = quiet.length
    val revGraph = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
    val ans = Array.fill[Int](n)(0)

    def buildGraphs():Unit = {
      richer foreach(
        r => { revGraph(r(1)) += r(0) }
      )
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
        ans(i) = quiet.indexOf(r.map(a => quiet(a)).min)
      }
    }

    def findRicherThanI(i: Int): mutable.Set[Int] = {
      val richerThanI = mutable.Set(i)
      bfs(richerThanI)

      @tailrec
      def bfs(r: mutable.Set[Int]): Unit = {
        if(r.isEmpty) {
          return
        }
        val newRicher = r.flatMap(e => revGraph(e))
        richerThanI.addAll(newRicher)
        bfs(newRicher)
      }
      richerThanI
    }

    buildGraphs()
    buildAns()

    ans
  }

}
