package org.sbk.leet
package dfs

/*
1192. Critical Connections in a Network
https://leetcode.com/problems/critical-connections-in-a-network/
 */
class CriticalConnectionsInNetwork {

    def criticalConnections(n: Int, connections: List[List[Int]]): List[List[Int]] = {
        import scala.collection.mutable
        import scala.collection.mutable._
        val graph = new mutable.HashMap[Int, ListBuffer[Int]]()
        val ans = new mutable.HashSet[List[Int]]()
        val labels = Array.fill[Int](n)(-1)

        def dfs(u: Int, parent: Int, preLabel: Int): Int =  {
            if(labels(u) > 0) return labels(u)
            labels(u) = preLabel + 1
            var minLabel = Int.MaxValue
            graph(u).filter(v => v != parent) foreach(v => {
                val recursiveLabel = dfs(v, u, labels(u))
                if(labels(u) >= recursiveLabel) ans.remove(List(u min v, u max v))
                minLabel = minLabel min recursiveLabel
            })
            minLabel
        }
        connections foreach (
            l => {
                graph(l.head) = graph.getOrElse(l.head, new ListBuffer[Int]()) += l.last
                graph(l.last) = graph.getOrElse(l.last, new ListBuffer[Int]()) += l.head
                ans += List(l.head min l.last, l.head max l.last)
            }
          )
        dfs(0, -1, 0)
        ans.toList
    }

}
