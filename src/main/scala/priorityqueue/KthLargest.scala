package org.sbk.leet
package priorityqueue

class KthLargest(k: Int, nums: Array[Int]) {
    import scala.collection.mutable

    val minQ: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()(Ordering[Int].reverse) ++ nums

    def add(v: Int): Int = {
        minQ += v
        while(minQ.size > k) minQ.dequeue()
        minQ.head
    }

}
