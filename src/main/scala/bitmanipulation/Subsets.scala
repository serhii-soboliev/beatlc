package org.sbk.leet
package bitmanipulation

/*
    78. Subsets
    https://leetcode.com/problems/subsets/
 */

class Subsets {

    def subsets(nums: Array[Int]): List[List[Int]] = {

        def createPermutation(a: Array[Int], n: Int): List[Int] = {
            import scala.collection.mutable.ListBuffer
            val r = new ListBuffer[Int]()
            for ((v, i) <- n.toBinaryString.reverse.zipWithIndex) {
                if (v == '1') {
                    r += a(i)
                }
            }
            r.toList.sorted
        }

        import scala.collection.mutable
        val res = new mutable.HashSet[List[Int]]
        val k = scala.math.pow(2, nums.length).toInt
        for (i <- 0 until k) {
            res += createPermutation(nums, i)
        }
        res.toList
    }

}
