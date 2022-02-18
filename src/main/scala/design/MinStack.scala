package org.sbk.leet
package design

/*
155. Min Stack
https://leetcode.com/problems/min-stack/
 */
class MinStack {

    import scala.collection.mutable

    private val stack = new mutable.Stack[Int]()

    private var minQ = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)

    def push(v: Int): Unit = {
        stack.push(v)
        minQ += v
    }

    def pop(): Unit = {
        val res = stack.pop()
        var found = false
        minQ = minQ.filter(x => found || x != res || { found=true; false })
    }

    def top(): Int = {
        stack.head
    }

    def getMin(): Int = {
        minQ.head
    }
}
