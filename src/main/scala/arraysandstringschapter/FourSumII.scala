package org.sbk.leet
package arraysandstringschapter

/*
454. 4Sum II
https://leetcode.com/problems/4sum-ii/
 */
class FourSumII {

    def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
        val sumToCntAB = (for (a <- A; b <- B) yield a + b).groupBy(identity).view.mapValues(_.length).toMap
        (for (c <- C; d <- D) yield sumToCntAB.getOrElse(- c - d, 0)).sum
    }

    def fourSumCountSumsCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
        val aPlusB: Map[Int, Int] = (for {
            i <- A
            j <- B
        } yield i + j).groupBy(identity).view.mapValues(_.length).toMap

        val cPlusD: Map[Int, Int] = (for {
            i <- C
            j <- D
        } yield i + j).groupBy(identity).view.mapValues(_.length).toMap

        aPlusB
          .map(tuple => {
              val (value: Int, count: Int) = tuple
              cPlusD.getOrElse(-value, 0) * count
          })
          .sum
    }

    def fourSumCountBigArray(nums1: Array[Int],
                             nums2: Array[Int],
                             nums3: Array[Int],
                             nums4: Array[Int]): Int = {
        val nums12 = for {
            i <- nums1
            j <- nums2
        } yield i + j

        val nums34 = for {
            i <- nums3
            j <- nums4
        } yield i + j

        val allSums = for {
            i <- nums12
            j <- nums34
        } yield i + j
        allSums.count(n => n == 0)
    }

    def fourSumCountNaive(nums1: Array[Int],
                          nums2: Array[Int],
                          nums3: Array[Int],
                          nums4: Array[Int]): Int = {
        var r: Int = 0
        val n = nums1.length
        (0 until n) foreach (
          i => {
              (0 until n) foreach (
                j => {
                    (0 until n) foreach (
                      k => {
                          (0 until n) foreach (
                            l => {
                                if (nums1(i) + nums2(j) + nums3(k) + nums4(l) == 0) r += 1
                            })
                      })
                })
          })
        r
    }

}
