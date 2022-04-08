package org.sbk.leet
package bfs

/*
934. Shortest Bridge
https://leetcode.com/problems/shortest-bridge/
 */
class ShortestBridge {

    def shortestBridge(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable
        val n = grid.length
        val dirs = Array((0,-1), (0, 1), (1, 0), (-1,0))
        val res = Array.fill[Array[Int]](n)(Array.fill[Int](n)(-1))

        def inBorder(p: (Int, Int)): Boolean = p._1 >= 0 && p._1 < n && p._2 >= 0 && p._2 < n

        def addIslandToQueue(v: (Int, Int)): mutable.Queue[(Int, Int)] = {
            val q = new mutable.Queue[(Int, Int)]()

            def bfs(p: (Int, Int)): Unit = {
                q += p
                grid(p._1)(p._2) = -1
                res(p._1)(p._2) = 0
                dirs.foreach(dir => {
                    val newP = (p._1 + dir._1, p._2 + dir._2)
                    if(inBorder(newP) && grid(newP._1)(newP._2) == 1) {
                        q += newP
                        bfs(newP)
                    }
                })
            }

            bfs(v)
            q
        }

        val q = (for {i <- 0 until n; j <- 0 until n} yield (i, j))
          .find(v => grid(v._1)(v._2) == 1)
          .map(v => addIslandToQueue(v))
          .get

        while(q.nonEmpty) {
            val p = q.dequeue()
            dirs.foreach(dir => {
                val newP = (p._1 + dir._1, p._2 + dir._2)
                if(inBorder(newP)) {
                    if(grid(newP._1)(newP._2) == 0) {
                        q += newP
                        grid(newP._1)(newP._2) = -1
                        res(newP._1)(newP._2) = res(p._1)(p._2) + 1
                    } else if(grid(newP._1)(newP._2) == 1) {
                        return res(p._1)(p._2)
                    }
                }
            })
        }
        -1
    }
}
