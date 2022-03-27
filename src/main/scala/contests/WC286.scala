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
}
