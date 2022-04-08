package org.sbk.leet
package bfs



/*
1926. Nearest Exit from Entrance in Maze
https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 */
class NearestExitFromEntranceInMaze {

    def nearestExit(maze: Array[Array[Char]], e: Array[Int]): Int = {
        import scala.collection.mutable
        val m = maze.length
        val n = maze.headOption.get.length
        val dirs = Array((0,-1), (0, 1), (1, 0), (-1,0))
        val dis = Array.fill[Array[Int]](m)(Array.fill[Int](n)(-1))

        def inBorder(p: (Int, Int)): Boolean = p._1 >= 0 && p._1 < m && p._2 >= 0 && p._2 < n

        def isEntrance(p: (Int, Int)): Boolean = p._1 == e(0) && p._2 == e(1)

        def isExit(p: (Int, Int)): Boolean = (p._1 == 0 || p._1 == m - 1 || p._2 == 0 || p._2 == n - 1) && !isEntrance(p)

        val q = mutable.Queue[(Int, Int)]()
        q.addOne((e(0), e(1)))
        dis(e(0))(e(1)) = 0
        maze(e(0))(e(1)) = '+'

        while(q.nonEmpty) {
            val p = q.dequeue()
            dirs.foreach(dir => {
                val nP = (p._1 + dir._1, p._2 + dir._2)
                if(inBorder(nP) && maze(nP._1)(nP._2) == '.') {
                    if(isExit(nP)) {
                        return dis(p._1)(p._2) + 1
                    } else {
                        q += nP
                        dis(nP._1)(nP._2) = dis(p._1)(p._2) + 1
                        maze(nP._1)(nP._2) = '+'
                    }
                }
            })
        }
        -1
    }
}
