package org.sbk.leet
package dfs

import scala.collection.mutable.ArrayBuffer


/*
847. Shortest Path Visiting All Nodes
https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 */
class ShortestPathVisitingAllNodes {

    def shortestPathLength(graph: Array[Array[Int]]): Int = {
        import scala.collection.mutable

        val initial = graph.indices.map(n => (n, 1 << n))

        val lengths = mutable.Map[(Int, Int), Int](initial.map((_, 0)): _*)
        val q = mutable.Queue[(Int, Int)](initial: _*)

        val allVisited = (1 << graph.length) - 1

        while (q.nonEmpty) {
            val (n, v) = q.dequeue()
            val l = lengths(n, v) + 1

            graph(n).foreach { n2 =>
                val v2 = v | (1 << n2)

                if (v2 == allVisited) return l

                val l2 = lengths.getOrElse((n2, v2), Int.MaxValue)

                if (l2 > l) {
                    lengths((n2, v2)) = l
                    q.enqueue((n2, v2))
                }
            }
        }

        0
    }

    def shortestPathLengthDPDFS(graph: Array[Array[Int]]): Int = {

        import scala.collection.mutable

        val n = graph.length
        val endingMask = (1 << n) - 1
        val cache = mutable.HashMap[(Int, Int), Int]()

        def dp(node: Int, mask: Int): Int = {
            if (cache.contains((node, mask))) return cache((node, mask))
            if ((mask & (mask - 1)) == 0) return 0
            cache((node, mask)) = Integer.MAX_VALUE - 1
            for (nei <- graph(node)) {
                if ((mask & (1 << nei)) != 0) {
                    val alreadyVisited = 1 + dp(nei, mask)
                    val notVisited = 1 + dp(nei, mask ^ (1 << node))
                    cache((node, mask)) = cache((node, mask)) min alreadyVisited min notVisited
                }
            }
            cache(node, mask)
        }

        (0 until n).map(k => dp(k, endingMask)).min
    }

}

object ShortestPathVisitingAllNodes {
    def main(args: Array[String]): Unit = {
        println(new ShortestPathVisitingAllNodes().shortestPathLength(
            Array(Array(1), Array(0,2,4), Array(1,3), Array(2), Array(1,5), Array(4))
        ))

        println(new ShortestPathVisitingAllNodes().shortestPathLength(
            Array(Array(1, 2, 3), Array(0), Array(0), Array(0))
        ))
    }
}
