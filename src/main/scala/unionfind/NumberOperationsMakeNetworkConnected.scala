package org.sbk.leet
package unionfind

import scala.annotation.tailrec

/*
1319. Number of Operations to Make Network Connected
https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
class NumberOperationsMakeNetworkConnected {

    def makeConnected(n: Int, connections: Array[Array[Int]]): Int = {

        @tailrec
        def getParent(n: Int, parent: Array[Int]): Int = {
            if (parent(n) == -1) n
            else getParent(parent(n), parent)
        }

        def union(n1: Int, n2: Int, parent: Array[Int]): Unit = {
            val p1 = getParent(n1, parent)
            val p2 = getParent(n2, parent)
            if (p1 != p2) {
                parent(p1) = p2
            }
        }

        val parent = Array.fill(n)(-1)
        var extra = 0
        connections.foreach { con =>
            val n1 = con(0)
            val n2 = con(1)
            val p1 = getParent(n1, parent)
            val p2 = getParent(n2, parent)
            if (p1 != p2) union(n1, n2, parent)
            else extra += 1
        }
        val parents = (0 until n).map(i => getParent(i, parent))
        val distinctParentSize = parents.toSet.size
        if (distinctParentSize == 0) 0
        else if (distinctParentSize - 1 <= extra) distinctParentSize - 1
        else -1
    }

}
