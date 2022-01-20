package org.sbk.leet

import scala.collection.mutable.ArrayBuffer


/*
  329. Longest Increasing Path in a Matrix
  https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
class LongestIncreasingPathInAMatrix {

  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    val n = matrix.length
    val m = matrix(0).length
    val longestPathsMemo = Array.fill[Array[Int]](n)(Array.fill[Int](m)(-1))

    def dfs(i: Int, j: Int): Int = {
      if(longestPathsMemo(i)(j) > -1) {
        return longestPathsMemo(i)(j)
      }

      def findNeighbors(i: Int, j: Int): Array[(Int, Int)] = {
        val nei = ArrayBuffer[(Int, Int)]()
        if(i > 0) {
          nei += Tuple2(i-1, j)
        }
        if(i < n-1) {
          nei += Tuple2(i+1, j)
        }
        if(j > 0) {
          nei += Tuple2(i, j-1)
        }
        if(j < m-1) {
          nei += Tuple2(i, j+1)
        }
         nei.toArray
      }

      val curVal = matrix(i)(j)
      var longestPathFromThere = 0
      val neighbors = findNeighbors(i, j)
      for((k1, k2) <- neighbors) {
        val v = matrix(k1)(k2)
        if (v > curVal) {
          longestPathFromThere = Math.max(longestPathFromThere, dfs(k1, k2))
        }
      }
      longestPathsMemo(i)(j) = 1 + longestPathFromThere
      longestPathsMemo(i)(j)
    }

    def calculatePaths(): Unit = {
      for (i <- 0 until n) {
        for(j <- 0 until m) {
          dfs(i,j)
        }
      }
    }

    calculatePaths()
    longestPathsMemo.flatten.max
  }

}
