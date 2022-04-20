package org.sbk.leet
package hashtables

import bfs.WordLadder

/*
1615. Maximal Network Rank
https://leetcode.com/problems/maximal-network-rank/
 */
class MaximalNetworkRank {

    def maximalNetworkRank(n: Int, roads: Array[Array[Int]]): Int = {
        import scala.collection.mutable

        val m = mutable.HashMap[Int, mutable.Set[Int]]().withDefaultValue(mutable.HashSet[Int]())

        for(r <- roads) {
            m.getOrElseUpdate(r(0), mutable.Set[Int]()) += r(1)
            m.getOrElseUpdate(r(1), mutable.Set[Int]()) += r(0)
        }

        (0 until n)
          .combinations(2)
          .map { case Seq(i, j) => m(i).size + m(j).size - (if (m(i).contains(j)) 1 else 0)}
          .max
    }

}

object MaximalNetworkRank {

    def main(args: Array[String]): Unit = {
        val m = new MaximalNetworkRank()
        println(m.maximalNetworkRank(4, Array(Array(0,1), Array(0,3), Array(1,2), Array(1,3))))
    }
}
