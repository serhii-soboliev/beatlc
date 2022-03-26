package org.sbk.leet
package dfs



/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/
 */
class NumberOfIslands {

    import scala.collection.mutable.ArrayBuffer

    def numIslands(grid: Array[Array[Char]]): Int = {
        var numIslands = 0
        val n = grid.length
        val m = grid.headOption.get.length

        def getNeighbors(i: Int, j:Int): Array[(Int, Int)] = {
            val res = new ArrayBuffer[(Int, Int)]
            if(i > 0) res.addOne(i-1, j)
            if(i < grid.length-1) res.addOne(i+1, j)
            if(j > 0) res.addOne(i, j-1)
            if(j < grid.headOption.get.length-1) res.addOne(i, j+1)
            res.toArray
        }

        def clearIsland(i: Int, j: Int) : Unit = {
            getNeighbors(i, j)
              .filter { case (k, l) => grid(k)(l) == '1' }
              .foreach { case (k, l) =>
                  grid(k)(l) = '0'
                  clearIsland(k, l)
              }
        }

        def countIslands()  : Unit = {
            for (i <- 0 until n; j <- 0 until m; if grid(i)(j) == '1') {
                numIslands += 1
                clearIsland(i, j)
            }
        }

        countIslands()
        numIslands
    }
}
