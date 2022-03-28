package org.sbk.leet
package dfs

/*
1254. Number of Closed Islands
https://leetcode.com/problems/number-of-closed-islands/
 */
class NumberOfClosedIslands {

    def closedIsland(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable.ArrayBuffer

        var numOfClosedIsland = 0
        val n = grid.length
        val m = grid.headOption.get.length

        def getNeighbors(i: Int, j:Int): Array[(Int, Int)] = {
            val res = new ArrayBuffer[(Int, Int)]
            if(i > 0) res.addOne(i-1, j)
            if(i < n-1) res.addOne(i+1, j)
            if(j > 0) res.addOne(i, j-1)
            if(j < m-1) res.addOne(i, j+1)
            res.toArray
        }

        def isBorder(i: Int, j:Int) : Boolean = {
            i == 0 || i == n-1 || j == 0 || j == m-1
        }

        def isClosedIsland(m: Int, n: Int) : Boolean = {
            var isClosed = !isBorder(m,n)

            def dfs(i: Int, j: Int) : Unit = {
                grid(i)(j) = 1
                getNeighbors(i, j)
                  .filter { case (k, l) => grid(k)(l) == 0 }
                  .foreach { case (k, l) =>
                      if(isBorder(k,l)) isClosed = false
                      grid(k)(l) = 1
                      dfs(k, l)
                  }
            }
            dfs(m, n)
            isClosed
        }

        def countClosedIslands()  : Unit = {
            for (i <- 0 until n; j <- 0 until m; if grid(i)(j) == 0) {
                if(isClosedIsland(i, j)) numOfClosedIsland += 1
            }
        }

        countClosedIslands()
        numOfClosedIsland
    }

}
