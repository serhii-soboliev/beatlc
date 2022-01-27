package org.sbk.leet
package dynamicprogramming


/*
63. Unique Paths II
https://leetcode.com/problems/unique-paths-ii/
 */
class UniquePaths2 {

    def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
        val n = obstacleGrid.length
        val m = obstacleGrid.headOption.get.length
        val s = Array.fill[Array[Int]](n)(Array.fill[Int](m)(0))
        s(0)(0) = 1
        for {
            i <- 0 until n
            j <- 0 until m
        } {
            if(obstacleGrid(i)(j) == 1) {
                s(i)(j) = 0
            } else {
                if(i > 0) s(i)(j) += s(i-1)(j)
                if(j > 0) s(i)(j) += s(i)(j-1)
            }
        }
        s(n - 1)(m - 1)
    }

    def uniquePathsWithObstaclesDFS(obstacleGrid: Array[Array[Int]]): Int = {

        val n = obstacleGrid.length
        val m = obstacleGrid.headOption.get.length
        val memo = Array.fill[Array[Int]](n)(Array.fill[Int](m)(-1))

        def dfs(i: Int, j: Int): Int = {
            val v = obstacleGrid(i)(j)
            if (v == 1) {
                memo(i)(j) = 0
                return 0
            }
            if (i == n - 1 && j == m - 1) {
                memo(i)(j) = 1
                return 1
            }
            var res = 0
            if (i < n - 1) {
                res += (if (memo(i + 1)(j) != -1) memo(i + 1)(j) else dfs(i + 1, j))
            }
            if (j < m - 1) {
                res += (if (memo(i)(j + 1) != -1) memo(i)(j + 1) else dfs(i, j + 1))
            }
            memo(i)(j) = res
            res
        }

        dfs(0, 0)
    }

}
