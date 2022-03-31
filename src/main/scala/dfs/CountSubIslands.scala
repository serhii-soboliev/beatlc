package org.sbk.leet
package dfs

/*
1905. Count Sub Islands
https://leetcode.com/problems/count-sub-islands/
 */
class CountSubIslands {

    def countSubIslands(g1: Array[Array[Int]], g2: Array[Array[Int]]): Int = {

        def f(i: Int, j: Int): Boolean = {
            if (i < 0 || i >= g1.length || j < 0 || j >= g1(0).length || g2(i)(j) <= 0) return true
            if (g2(i)(j) == 1 && g1(i)(j) != 1) return false
            g2(i)(j) = -1
            Seq((0, 1), (0, -1), (1, 0), (-1, 0)).map(d => f(i + d._1, j + d._2)).reduce(_ & _)
        }

        g1.indices.map(i => g1(0).indices.count(j => g2(i)(j) == 1 && f(i, j))).sum

    }

    def countSubIslandsNaive(grid1: Array[Array[Int]], grid2: Array[Array[Int]]): Int = {

        import scala.collection.mutable.ArrayBuffer

        val n = grid2.length
        val m = grid2.headOption.get.length

        def getNeighbors(i: Int, j:Int): Array[(Int, Int)] = {
            val res = new ArrayBuffer[(Int, Int)]
            if(i > 0) res.addOne(i-1, j)
            if(i < grid2.length-1) res.addOne(i+1, j)
            if(j > 0) res.addOne(i, j-1)
            if(j < grid2.headOption.get.length-1) res.addOne(i, j+1)
            res.toArray
        }

        def handleSubIsland(t: Int, p: Int) : Boolean = {
            var isSubIsland = true

            def dfs(i: Int, j: Int) : Unit = {
                grid2(i)(j) = 0
                if(grid1(i)(j) != 1) isSubIsland = false
                getNeighbors(i, j).foreach { case (k, l)  => if(grid2(k)(l) == 1) dfs(k, l)}
            }

            dfs(t, p)
            isSubIsland
        }

        def countSubIslands() : Int = {
            var subIslands = 0
            for (i <- 0 until n; j <- 0 until m; if grid2(i)(j) == 1) {
                if (handleSubIsland(i, j)) subIslands += 1
            }
            subIslands
        }

        countSubIslands()
    }
}
