package org.sbk.leet
package topologicalsort

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/*
802. Find Eventual Safe States
https://leetcode.com/problems/find-eventual-safe-states/
 */
class EventualSafeStates {

    def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
        val n = graph.length
        val safe = Array.fill[Boolean](n)(false)
        val r = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
        val rg = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])

        for (i <- graph.indices) {
            for (j <- graph(i)) {
                r(i) += j
                rg(j) += i
            }
        }

        val safeQueue = mutable.Queue[Int]()
        for (i <- 0 until n) {
            if (r(i).isEmpty) {
                safeQueue += i
                safe(i) = true
            }
        }

        while (safeQueue.nonEmpty) {
            val v = safeQueue.dequeue()
            for (e <- rg(v)) {
                if (r(e).nonEmpty) {
                    r(e) -= v
                    if (r(e).isEmpty) {
                        safeQueue += e
                    }
                }
            }
            safe(v) = true
        }

        safe.zipWithIndex
          .filter { case (data, _) => data }
          .map { case (_, index) => index }
          .toList
    }
}

object EventualSafeStates {
    def main(args: Array[String]): Unit = {
        val ess = new EventualSafeStates
        print(ess.eventualSafeNodes(Array(Array(1, 2), Array(2, 3), Array(5), Array(0), Array(5), Array(), Array())))
    }
}
