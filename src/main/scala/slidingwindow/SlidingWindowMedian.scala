package org.sbk.leet
package slidingwindow

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/*
480. Sliding Window Median
https://leetcode.com/problems/sliding-window-median/
 */

class MedianHeap {

    private var minHeap: mutable.PriorityQueue[Int] = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
    private var maxHeap: mutable.PriorityQueue[Int] = new mutable.PriorityQueue[Int]()

    def this(nums: Seq[Int]) = {
        this()
        nums.foreach{
            n => this.insert(n)
        }
    }

    def balanceHeaps(): Unit = {
        if (maxHeap.size > minHeap.size + 1) {
            minHeap += maxHeap.dequeue()
        } else if (maxHeap.size < minHeap.size) {
            maxHeap += minHeap.dequeue()
        }
    }

    def insert(x: Int): Unit = {
        if (maxHeap.isEmpty || maxHeap.head >= x) maxHeap.enqueue(x)
        else minHeap.enqueue(x)
        balanceHeaps()
    }

    def remove(x: Int) : Unit = {

        def removeFirstElementOccurrence[A](xs: mutable.PriorityQueue[A])(p: A => Boolean) = {
            var found = false
            xs.filter(x => found || !p(x) || { found=true; false })
        }

        if(x <= maxHeap.head) {
            maxHeap = removeFirstElementOccurrence(maxHeap)(_ == x)
        } else {
            minHeap = removeFirstElementOccurrence(minHeap)(_ == x)
        }
    }

    def findMedian(): Double = {
        if (maxHeap.size == minHeap.size)  (maxHeap.head.toDouble + minHeap.head) / 2
        else maxHeap.head
    }
}


class SlidingWindowMedian {



    def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
//        (0 until k) foreach {
//
//        }
//        val res = new ArrayBuffer[Double]
//        res.toArray
        null
    }


}


