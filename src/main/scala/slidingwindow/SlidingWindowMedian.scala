package org.sbk.leet
package slidingwindow

/*
480. Sliding Window Median
https://leetcode.com/problems/sliding-window-median/
 */
class SlidingWindowMedian {

    def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {

        def findMedian(ar: Array[Int]): Double = {
            val sortedSeq = ar.sortWith(_ < _)
            if (ar.length % 2 == 1) return sortedSeq(sortedSeq.length / 2)
            val (up, down) = sortedSeq.splitAt(ar.length / 2)
            val (u, d): (Long, Long) = (up.last, down.head)
            (u + d).toDouble / 2
        }

        nums
          .sliding(k)
          .map(a => findMedian(a))
          .toArray
    }

}
