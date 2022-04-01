package org.sbk.leet
package bfs

/*
417. Pacific Atlantic Water Flow
https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
class PacificAtlanticWaterFlow {

    def pacificAtlantic(heights: Array[Array[Int]]): List[List[Int]] = {
        import scala.collection.mutable

        val n = heights.length
        val m = heights.headOption.get.length
        val dirs = Array((0,-1), (0, 1), (1, 0), (-1,0))

        val visitedP, visitedA = Array.fill[Array[Int]](n)(Array.fill[Int](m)(-1))
        val pQ, aQ = mutable.Queue[(Int, Int)]()

        for (i <- 0 until n) {
            pQ.addOne((i, 0))
            aQ.addOne((i, m - 1))
            visitedP(i)(0) = 1
            visitedA(i)(m - 1) = 2
        }
        for (i <- 0 until m) {
            pQ.addOne((0, i))
            aQ.addOne((n - 1, i))
            visitedP(0)(i) = 1
            visitedA(n - 1)(i) = 2
        }

        def inBorder(p: (Int, Int)): Boolean = p._1 >= 0 && p._1 < n && p._2 >= 0 && p._2 < m

        def couldFlow(p1: (Int, Int), p2: (Int, Int)) : Boolean = heights(p1._1)(p1._2) <= heights(p2._1)(p2._2)

        while (pQ.nonEmpty) {
            val p = pQ.dequeue()
            dirs.foreach(dir => {
                val newP = (p._1 + dir._1, p._2 + dir._2)
                if(inBorder(newP) && couldFlow(p, newP) && visitedP(newP._1)(newP._2) == -1) {
                    visitedP(newP._1)(newP._2) = 1
                    pQ.addOne(newP)
                }
            })
        }

        while (aQ.nonEmpty) {
            val p = aQ.dequeue()
            dirs.foreach(dir => {
                val newP = (p._1 + dir._1, p._2 + dir._2)
                if(inBorder(newP) && couldFlow(p, newP) && visitedA(newP._1)(newP._2) == -1) {
                    visitedA(newP._1)(newP._2) = 2
                    aQ.addOne(newP)
                }
            })
        }

        (for {i <- 0 until n; j <- 0 until m; if visitedP(i)(j) == 1 && visitedA(i)(j) == 2} yield List(i,j)).toList

    }

}
