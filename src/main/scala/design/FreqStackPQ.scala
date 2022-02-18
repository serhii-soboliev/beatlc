package org.sbk.leet
package design

class FreqStackPQ() {
    import scala.collection.mutable
    //tuple item 1 is the number,
    //tuple item 2 is the frequency,
    //tuple item 3 is the operation frequency - needed as a tiebreaker for the frequency
    val priorityQueue: mutable.PriorityQueue[(Int, Int, Int)] = mutable.PriorityQueue[(Int, Int, Int)]()(
        Ordering.fromLessThan((item1, item2) => {
            if (item1._2 < item2._2) true
            else if (item2._2 < item1._2) false
            else if (item1._3 < item2._3) true
            else false
        })
    )

    //maintains how many times a number is in our list.
    val numberMap: mutable.Map[Int, Int] = mutable.Map[Int, Int]()
    var operationCount: Int = 0

    def push(x: Int): Unit = {
        val frequency = numberMap.getOrElse(x, 0) + 1
        operationCount = operationCount + 1
        numberMap(x) = frequency
        priorityQueue.enqueue((x, frequency, operationCount))
    }

    def pop(): Int = {
        val returnValue: Int = priorityQueue.dequeue()._1
        numberMap(returnValue) = numberMap(returnValue) - 1
        returnValue
    }
}
