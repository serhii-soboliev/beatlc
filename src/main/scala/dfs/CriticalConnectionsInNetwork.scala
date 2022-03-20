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
        var time = 0
        val graph = new mutable.HashMap[Int, ListBuffer[Int]]()
        val result = new ListBuffer[List[Int]]()
        val visited = Array.fill[Boolean](n)(false)
        val timestamp = Array.fill[Int](n)(0)

        def dfs(vertex: Int, prev: Int): Unit =  {
            visited(vertex) = true
            time += 1
            timestamp(vertex) = time
            val curTimeStamp = timestamp(vertex)
            graph(vertex).filter(v => v != prev).foreach(v => {
                if(!visited(v)) dfs(v, vertex)
                timestamp(vertex) = timestamp(vertex) min timestamp(v)
                if(curTimeStamp < timestamp(v)) result += List(vertex,v)
            })
        }

        connections foreach (l => {
                graph(l.head) = graph.getOrElse(l.head, new ListBuffer[Int]()) += l.last
                graph(l.last) = graph.getOrElse(l.last, new ListBuffer[Int]()) += l.head
        })
        dfs(0, -1)
        result.toList
    }


}
