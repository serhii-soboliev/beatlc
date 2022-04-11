package org.sbk.leet
package unionfind

/*
1319. Number of Operations to Make Network Connected
https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
class NumberOperationsMakeNetworkConnected {

    def makeConnected(n: Int, connections: Array[Array[Int]]): Int = {

        import scala.collection.mutable
        if (connections.length < n - 1) return -1
        var res = 0
        val isConnected = Array.fill[Array[Int]](n)(Array.fill[Int](n)(0))
        val visited = mutable.HashSet[Int]()

        for (c <- connections) {
            isConnected(c(0))(c(1)) = 1
            isConnected(c(1))(c(0)) = 1
        }

        def dfs(i: Int): Unit = {
            for {j <- isConnected.indices; if isConnected(i)(j) == 1 && !visited.contains(j)} {
                visited += j
                dfs(j)
            }
        }

        for (i <- isConnected.indices; if !visited.contains(i)) {
            visited += i
            res += 1
            dfs(i)
        }

        res - 1
    }
}
