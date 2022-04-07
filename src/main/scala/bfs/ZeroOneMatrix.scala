package org.sbk.leet
package bfs



/*
542. 01 Matrix
https://leetcode.com/problems/01-matrix/
 */
class ZeroOneMatrix {
    def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
        import scala.collection.mutable
        val n = mat.length
        val m = mat.headOption.get.length
        val dirs = Array((0,-1), (0, 1), (1, 0), (-1,0))

        val res = Array.fill[Array[Int]](n)(Array.fill[Int](m)(-1))
        val q = mutable.Queue[(Int, Int)]()

        def inBorder(p: (Int, Int)): Boolean = p._1 >= 0 && p._1 < n && p._2 >= 0 && p._2 < m

        for {i <- 0 until n; j <- 0 until m; if mat(i)(j) == 0} {
            res(i)(j) = 0
            q.addOne((i,j))
        }

        while(q.nonEmpty) {
            val p = q.dequeue()
            dirs.foreach(dir => {
                val newP = (p._1 + dir._1, p._2 + dir._2)
                if(inBorder(newP) && res(newP._1)(newP._2) == -1) {
                    res(newP._1)(newP._2) = res(p._1)(p._2) + 1
                    q.addOne(newP)
                }
            })
        }
        res
    }
}
