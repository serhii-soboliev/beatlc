package org.sbk.leet
package design

/*
1656. Design an Ordered Stream
https://leetcode.com/problems/design-an-ordered-stream/
 */
class OrderedStream(_n: Int) {
    import scala.collection.mutable.ListBuffer
    private val ar = new Array[String](_n)
    private var ptr = 0
    def insert(idKey: Int, value: String): List[String] = {
        val id = idKey - 1
        ar(id) = value
        if(id == ptr) {
            streamFromIdx(id)
        } else {
            List()
        }
    }

    def streamFromIdx(idx: Int): List[String] = {
        val l = new ListBuffer[String]()
        (idx until _n) foreach(i => {
            if(ar(i) != null) {
                l += ar(i)
            } else {
                ptr = i
                return l.toList
            }
        })
        l.toList
    }

}


