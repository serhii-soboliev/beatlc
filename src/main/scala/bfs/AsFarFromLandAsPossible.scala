package org.sbk.leet
package bfs

/*
1162. As Far from Land as Possible
https://leetcode.com/problems/as-far-from-land-as-possible/
 */
class AsFarFromLandAsPossible {

    def maxDistance(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable

        val n = grid.length
        val dis = Array.fill[Array[Int]](n)(Array.fill[Int](n)(-1))
        val dirs = Array((-1,0), (1,0), (0,1), (0,-1))
        val q = mutable.Queue[(Int, Int)]()
        var maxDis = 0

        def inBorder(p: (Int, Int)): Boolean = {
            p._1 >= 0 && p._1 < n && p._2 >= 0 && p._2 < n
        }

        for (i <- 0 until n; j <- 0 until n; if grid(i)(j) == 1) {
            q.addOne(i, j)
            dis(i)(j) = 0
        }

        if(q.isEmpty || q.size == n*n) return -1

        while(q.nonEmpty) {
            val p = q.dequeue()
            dirs.foreach(dir => {
                val newP = (p._1 + dir._1, p._2 + dir._2)
                if(inBorder(newP) && dis(newP._1)(newP._2) == -1) {
                    dis(newP._1)(newP._2) = dis(p._1)(p._2) + 1
                    q.addOne(newP)
                    maxDis = maxDis max dis(newP._1)(newP._2)
                }
            })
        }

        maxDis
    }
}
