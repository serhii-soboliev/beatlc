package org.sbk.leet
package bfs


import scala.collection.mutable


/*
1129. Shortest Path with Alternating Colors
https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */
class ShortestPathWithAlternatingColors {


    def shortestAlternatingPaths(n: Int, redEdges: Array[Array[Int]], blueEdges: Array[Array[Int]]): Array[Int] = {

        if (n <= 0) return Array()
        if (n == 1) return Array(0)
        val res = Array.fill(n)(-1)
        res(0) = 0

        import scala.collection.mutable
        case class Edge(from: Int, to: Int, col: Int)

        val graph = mutable.HashMap[Int, mutable.Set[Edge]]()
        redEdges.foreach(re => graph.getOrElseUpdate(re(0), mutable.Set[Edge]()) += Edge(re(0), re(1), 0))
        blueEdges.foreach(re => graph.getOrElseUpdate(re(0), mutable.Set[Edge]()) += Edge(re(0), re(1), 1))


        if (graph.isEmpty || !graph.contains(0)) return res

        val q = mutable.Queue[Edge]() ++ graph(0)
        val isVisited = mutable.Set[Edge]()
        var step = 1

        while (q.nonEmpty) {
            val k = q.size
            for (_ <- 0 until k) {
                val currE = q.dequeue
                isVisited add currE
                val to = currE.to
                val col = currE.col
                res(to) = if (res(to) == -1) step else res(to) min step
                if (graph contains to)
                    for {e <- graph(to); if !isVisited.contains(e) && (e.col != col)}
                        q enqueue e
            }
            step += 1
        }
        res
    }



}

object ShortestPathWithAlternatingColors {
    def main(args: Array[String]): Unit = {
        new ShortestPathWithAlternatingColors().shortestAlternatingPaths(3, Array(Array(0,1), Array(1,2)), Array())
    }

}
