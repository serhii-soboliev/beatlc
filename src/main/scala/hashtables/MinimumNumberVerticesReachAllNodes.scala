package org.sbk.leet
package hashtables

/*
1557. Minimum Number of Vertices to Reach All Nodes
https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
class MinimumNumberVerticesReachAllNodes {

    def findSmallestSetOfVertices(n: Int, edges: List[List[Int]]): List[Int] = {
        val m1 = edges.groupBy(_(1)).view.mapValues(_.map(_.head).length).toMap
        (0 until n).filterNot(i => m1.contains(i)).toList
    }

    def findSmallestSetOfVerticesDiff(n: Int, edges: List[List[Int]]): List[Int] = {
        (0 until n).diff(edges.map(_.last)).toList
    }


}

object MinimumNumberVerticesReachAllNodes {

    def main(args: Array[String]): Unit = {
        println(new MinimumNumberVerticesReachAllNodes()
          .findSmallestSetOfVertices(6,  List(List(0,1),List(0,2),List(2,5),List(3,4),List(4,2))))
    }
}
