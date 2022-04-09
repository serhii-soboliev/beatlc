package org.sbk.leet
package bfs



/*
797. All Paths From Source to Target
https://leetcode.com/problems/all-paths-from-source-to-target/
 */
class AllPathsFromSourceToTarget {

    def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
        val result = collection.mutable.ListBuffer[List[Int]]()

        def dfs(path: List[Int]): Unit = {
            if (path.head == graph.length - 1)
                result += path.reverse
            else
                graph(path.head).foreach(nextNode => dfs(nextNode :: path))
        }

        dfs(List(0))
        result.toList
    }
}
