package org.sbk.leet

import scala.collection.mutable.ArrayBuffer
import scala.util.chaining._

/*
  329. Longest Increasing Path in a Matrix
  https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
class LongestIncreasingPathInAMatrix {

    def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
        lazy val lengths: IndexedSeq[IndexedSeq[Lazy[Int]]] =
            IndexedSeq.tabulate(matrix.length, matrix.headOption.map(_.length).getOrElse(0)) { (i1, j1) =>
                Lazy {
                    Iterable((i1 - 1, j1), (i1 + 1, j1), (i1, j1 - 1), (i1, j1 + 1))
                      .collect {
                          case (i2, j2)
                              if matrix.isDefinedAt(i2)
                                && matrix(i2).isDefinedAt(j2)
                                && matrix(i1)(j1) < matrix(i2)(j2) =>
                              lengths(i2)(j2).get
                      }
                      .maxOption
                      .getOrElse(0)
                      .pipe(_ + 1)
                }
            }
        lengths.flatten.map(_.get).maxOption.getOrElse(0)
    }

    private final class Lazy[+A](f: => A) {
        lazy val get: A = f
    }

    private object Lazy {
        def apply[A](f: => A) = new Lazy(f)
    }

    def longestIncreasingPathDFS(matrix: Array[Array[Int]]): Int = {
        val n = matrix.length
        val m = matrix.headOption.get.length
        val longestPathsMemo = Array.fill[Array[Int]](n)(Array.fill[Int](m)(-1))

        def dfs(i: Int, j: Int): Int = {
            if (longestPathsMemo(i)(j) > -1) longestPathsMemo(i)(j)

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

            val curVal = matrix(i)(j)
            var longestPathFromThere = 0
            val neighbors = findNeighbors(i, j)
            for ((k1, k2) <- neighbors) {
                val v = matrix(k1)(k2)
                if (v > curVal) {
                    longestPathFromThere = Math.max(longestPathFromThere, dfs(k1, k2))
                }
            }
            longestPathsMemo(i)(j) = 1 + longestPathFromThere
            longestPathsMemo(i)(j)
        }

        def calculatePaths(): Unit = {
            for {
                i <- 0 until n
                j <- 0 until m
            } {
                dfs(i, j)
            }
        }

        calculatePaths()
        longestPathsMemo.flatten.max
    }

}
