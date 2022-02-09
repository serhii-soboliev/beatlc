package org.sbk.leet
package slidingwindow

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/*
480. Sliding Window Median
https://leetcode.com/problems/sliding-window-median/
 */
class SlidingWindowMedianNaive {



    def medianSlidingWindowNaive(nums: Array[Int], k: Int): Array[Double] = {

        def findMedian(ar: Array[Int]): Double = {
            val sortedSeq = ar.sortWith(_ < _)
            if (ar.length % 2 == 1) return sortedSeq(sortedSeq.length / 2)
            val (up, down) = sortedSeq.splitAt(ar.length / 2)
            (up.last.toDouble + down.head) / 2
        }

        nums
          .sliding(k)
          .map(a => findMedian(a))
          .toArray
    }

}


