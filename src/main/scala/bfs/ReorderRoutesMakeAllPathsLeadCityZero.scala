package org.sbk.leet
package bfs



/*
1466. Reorder Routes to Make All Paths Lead to the City Zero
https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 */
class ReorderRoutesMakeAllPathsLeadCityZero {

    def minReorder(n: Int, connections: Array[Array[Int]]): Int = {
        import scala.collection.mutable
        val visited = mutable.Set[Int]()
        var res = 0
        val g = mutable.HashMap[Int, mutable.Set[(Int, Int)]]()

        for(c <- connections) {
            g.getOrElseUpdate(c(0), mutable.Set[(Int, Int)]()).addOne(1,c(1))
            g.getOrElseUpdate(c(1), mutable.Set[(Int, Int)]()).addOne(0,c(0))
        }

        def dfs(v: Int): Unit = {
            visited += v
            for((direction, to) <- g(v)) {
                if(!visited.contains(to)) {
                    res += direction
                    dfs(to)
                }
            }
        }

        dfs(0)
        res
    }

}
