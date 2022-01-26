package org.sbk.leet
package bitmanipulation

/*
980. Unique Paths III
https://leetcode.com/problems/unique-paths-iii/
 */
class UniquePaths3 {

    def uniquePathsIII(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable.ArrayBuffer
        import scala.util.control.Breaks._

        val n = grid.length
        val m = grid.headOption.get.length

        def findStartingPoint() : (Int, Int) = {
            for{
                i <- 0 until n
                j <- 0 until m
            } {
                if(grid(i)(j) == 1) {
                    return (i, j)
                }
            }
            (-1,-1)
        }

        def findNeighbors(i: Int, j: Int): Array[(Int, Int)] = {
            val nei = ArrayBuffer[(Int, Int)]()
            if (i > 0) {
                nei += Tuple2(i - 1, j)
            }
            if (i < n - 1) {
                nei += Tuple2(i + 1, j)
            }
            if (j > 0) {
                nei += Tuple2(i, j - 1)
            }
            if (j < m - 1) {
                nei += Tuple2(i, j + 1)
            }
            nei.toArray
        }

        var pathsCount = 0
        val zeroCount = grid.flatten.count(n => n == 0) + 1
        def dfs(i: Int, j: Int, visited: ArrayBuffer[(Int, Int)]): Unit = {
            visited += Tuple2(i,j)
            for((k,t) <- findNeighbors(i, j)) {
                breakable {
                    if(visited.contains((k,t))) {
                        break
                    }
                    val v = grid(k)(t)
                    if(v == -1) {
                        break
                    }
                    if (v == 2) {
                        if (visited.length == zeroCount) {
                            pathsCount += 1
                        }
                    }
                    if (v == 0 && visited.length < zeroCount) {
                        dfs(k, t, visited.clone())
                    }
                }
            }
        }
        val (i, j) = findStartingPoint()
        dfs(i, j, ArrayBuffer())
        pathsCount

    }

}
