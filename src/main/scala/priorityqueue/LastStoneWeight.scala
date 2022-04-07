package org.sbk.leet
package priorityqueue

/*
1046. Last Stone Weight
https://leetcode.com/problems/last-stone-weight/
 */
class LastStoneWeight {

    def lastStoneWeight(stones: Array[Int]): Int = {
        import scala.collection.mutable
        val pq =  mutable.PriorityQueue[Int]() ++ stones
        while(pq.size > 1) {
            val n = pq.dequeue() - pq.dequeue()
            if(n != 0) pq += n
        }
        if(pq.isEmpty) 0 else pq.dequeue()
    }
}
