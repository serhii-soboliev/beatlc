package org.sbk.leet
package hashtables


/*
347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentElements {
    def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
        nums
          .groupBy(identity)
          .view
          .mapValues(_.length)
          .toMap
          .toSeq.sortBy(_._2)(Ordering[Int].reverse)
          .take(k)
          .map(_._1)
          .toArray
    }
}
