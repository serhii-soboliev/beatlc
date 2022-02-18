package org.sbk.leet
package design

class MinStackTwoStacks {

    import scala.collection.mutable

    private val mins = mutable.Stack[Int]()
    private val stack = mutable.Stack[Int]()

    def top (): Int = {
        stack.top
    }

    def getMin(): Int = {
        mins.top
    }

    def push(x: Int): Unit = {
        if (mins.isEmpty || mins.top >= x)
            mins.push(x)
        stack.push(x)
    }

    def pop(): Unit = {
        if (mins.top == top)
            mins.pop()
        stack.pop()
    }


}
