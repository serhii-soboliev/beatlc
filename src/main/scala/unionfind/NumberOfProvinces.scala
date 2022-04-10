package org.sbk.leet
package unionfind



/*
547. Number of Provinces
https://leetcode.com/problems/number-of-provinces/
 */
class NumberOfProvinces {
    def findCircleNum(isConnected: Array[Array[Int]]): Int = {
        import scala.collection.mutable

        var res = 0
        val visited = mutable.HashSet[Int]()

        def dfs(i: Int) : Unit = {
            for(j <- isConnected.indices) {
                if(isConnected(i)(j) == 1 && !visited.contains(j)) {
                    visited += j
                    dfs(j)
                }
            }
        }
        for(i <- isConnected.indices) {
            if(!visited.contains(i)){
                visited += i
                res += 1
                dfs(i)
            }
        }
        res
    }
}
