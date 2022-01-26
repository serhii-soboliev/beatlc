package org.sbk.leet
package bitmanipulation

/*
980. Unique Paths III
https://leetcode.com/problems/unique-paths-iii/
 */
class UniquePaths3 {

    def uniquePathsIII(grid: Array[Array[Int]]): Int = {
        import scala.collection.mutable.ArrayBuffer

        val n = grid.length
        val m = grid.headOption.get.length

        def findStartingPoint(): IndexedSeq[(Int, Int)] = {
            for {
                i <- grid.indices
                j <- grid(i).indices
                if grid(i)(j) == 1
            } yield (i, j)
        }

        def findNeighbors(i: Int, j: Int): Array[(Int, Int)] = {
            val nei = ArrayBuffer[(Int, Int)]()
            if (i > 0) nei += Tuple2(i - 1, j)
            if (i < n - 1) nei += Tuple2(i + 1, j)
            if (j > 0) nei += Tuple2(i, j - 1)
            if (j < m - 1) nei += Tuple2(i, j + 1)
            nei.toArray
        }

        var pathsCount = 0
        val pathLength = grid.flatten.count(n => n == 0) + 1

        def dfs(i: Int, j: Int, visited: ArrayBuffer[(Int, Int)]): Unit = {
            visited += Tuple2(i, j)
            findNeighbors(i, j)
              .filter(l => !visited.contains(l))
              .filter(l => grid(l._1)(l._2) != 1)
              .foreach { case(k, t) =>
                  if (grid(k)(t) == 2 && visited.length == pathLength) pathsCount += 1
                  if (grid(k)(t) == 0 && visited.length < pathLength) dfs(k, t, visited.clone())
              }
        }
        findStartingPoint().headOption.foreach(n => dfs(n._1, n._2, ArrayBuffer()))
        pathsCount
    }

}
