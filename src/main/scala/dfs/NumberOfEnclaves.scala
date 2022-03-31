package org.sbk.leet
package dfs

/*
1020. Number of Enclaves
https://leetcode.com/problems/number-of-enclaves/
 */
class NumberOfEnclaves {

    def numEnclaves(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable.ArrayBuffer

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

        def isBorder(i: Int, j:Int) : Boolean = {
            i == 0 || i == n-1 || j == 0 || j == m-1
        }

        def handleEnclaveCandidate(t: Int, p: Int) : Int = {
            var isEnclave = true
            var enclaveNumber = 0

            def dfs(i: Int, j: Int) : Unit = {
                grid(i)(j) = 0
                if(isBorder(i,j)) isEnclave = false
                enclaveNumber += 1
                getNeighbors(i, j).foreach { case (k, l)  => if(grid(k)(l) == 1) dfs(k, l)}
            }

            dfs(t, p)
            if (isEnclave) enclaveNumber else 0
        }

        def countEnclaves():  Int = {
            var enclavesCount = 0
            for (i <- 0 until n; j <- 0 until m; if grid(i)(j) == 1) {
                enclavesCount += handleEnclaveCandidate(i,j)
            }
            enclavesCount
        }

        countEnclaves()

    }
}
