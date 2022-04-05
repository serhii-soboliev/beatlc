package org.sbk.leet
package bfs

/*
1091. Shortest Path in Binary Matrix
https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
class ShortestPathInBinaryMatrix {

    def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable
        if(grid(0)(0) != 0) return -1
        val n = grid.length
        val dirs = Array((-1,-1), (0, -1), (1, -1), (-1,0), (1,0), (-1,1), (0,1), (1,1))
        val dis = Array.fill[Array[Int]](n)(Array.fill[Int](n)(-1))
        dis(0)(0) = 1
        val q = mutable.Queue[(Int, Int)]()
        q.addOne((0,0))

        def inBorder(p: (Int, Int)): Boolean = {
            p._1 >= 0 && p._1 < n && p._2 >= 0 && p._2 < n
        }

        while(q.nonEmpty) {
            val p = q.dequeue()
            dirs.foreach(d => {
                val newP = (p._1 + d._1, p._2 + d._2)
                if(inBorder(newP) && grid(newP._1)(newP._2) == 0 && dis(newP._1)(newP._2) == -1) {
                    dis(newP._1)(newP._2) = dis(p._1)(p._2) + 1
                    q += newP
                }
            })
        }

        dis(n-1)(n-1)
    }

}
