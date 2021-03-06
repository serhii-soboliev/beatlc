package org.sbk.leet
package slidingwindow

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/*
295. Find Median from Data Stream
https://leetcode.com/problems/find-median-from-data-stream/
 */

class MedianFinder() {

    private val minHeap: mutable.PriorityQueue[Int] = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
    private val maxHeap: mutable.PriorityQueue[Int] = new mutable.PriorityQueue[Int]()

    def balanceHeaps(): Unit = {
        if (maxHeap.size > minHeap.size + 1) {
            minHeap += maxHeap.dequeue()
        } else if (maxHeap.size < minHeap.size) {
            maxHeap += minHeap.dequeue()
        }
    }

    def addNum(num: Int): Unit = {
        if (maxHeap.isEmpty || maxHeap.head >= num) maxHeap.enqueue(num)
        else minHeap.enqueue(num)
        balanceHeaps()
    }

    def findMedian(): Double = {
        if (maxHeap.size == minHeap.size)  (maxHeap.head.toDouble + minHeap.head) / 2
        else maxHeap.head
    }

}


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
        balanceHeaps()
    }

    def findMedian(): Double = {
        if (maxHeap.size == minHeap.size)  (maxHeap.head.toDouble + minHeap.head) / 2
        else maxHeap.head
    }
}

class SlidingWindowMedian {

    def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
        val res = new ArrayBuffer[Double]
        val mh = new MedianHeap(nums.slice(0, k))
        res += mh.findMedian()
        (k until nums.length) foreach {
            i => {
                mh.insert(nums(i))
                mh.remove(nums(i - k))
                res += mh.findMedian()
            }
        }
        res.toArray
    }

}


