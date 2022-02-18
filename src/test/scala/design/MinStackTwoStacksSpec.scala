package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MinStackTwoStacksSpec extends AnyFlatSpec with Matchers {

    "MinStackSpec" should "scenario 1" in {
        val minStack = new MinStackTwoStacks()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        minStack.getMin() should equal (-3)
        minStack.pop()
        minStack.top() should equal (0)
        minStack.getMin() should equal (-2)
    }
}
