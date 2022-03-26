package org.sbk.leet
package dfs

/*
695. Max Area of Island
https://leetcode.com/problems/number-of-islands/
 */
class MaxAreaOfIsland {

    def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {

        import scala.collection.mutable.ArrayBuffer

        var maxSquare = 0
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

        def calcSquare(i: Int, j: Int) : Int = {
            var square = 1
            grid(i)(j) = 0
            getNeighbors(i, j)
              .foreach { case (k, l) =>
                  if(grid(k)(l) == 1) {
                      grid(k)(l) = 0
                      val t = calcSquare(k, l)
                      square += t
                  }
              }
            square
        }

        def countIslands()  : Unit = {
            for (i <- 0 until n; j <- 0 until m; if grid(i)(j) == 1) {
                maxSquare = calcSquare(i, j) max maxSquare
            }
        }

        countIslands()
        maxSquare
    }
}
