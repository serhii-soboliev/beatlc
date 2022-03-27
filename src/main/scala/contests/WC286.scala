package org.sbk.leet
package contests




class WC286 {

    /*
        2215. Find the Difference of Two Arrays
    */
    def findDifference(nums1: Array[Int], nums2: Array[Int]): List[List[Int]] = {
        import scala.collection.mutable
        val hs1 = mutable.HashSet() ++ nums1
        val hs2 = mutable.HashSet() ++ nums2
        List(hs1.diff(hs2).toList, hs2.diff(hs1).toList)
    }

    /*
        2216. Minimum Deletions to Make Array Beautiful
     */
    def minDeletion(nums: Array[Int]): Int = {
        var d = 0
        val n = nums.length
        (0 until n - 1).foreach(i => {if(((i - d) % 2 == 0) && (nums(i) == nums(i+1))) d += 1})
        if((n - d) % 2 == 1) d +=1
        d
    }
}
