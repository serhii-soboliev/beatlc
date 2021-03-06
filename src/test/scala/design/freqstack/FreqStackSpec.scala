package org.sbk.leet
package design.freqstack

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FreqStackSpec extends AnyFlatSpec with Matchers{

    "FreqStack" should "scenario 1" in {
        val freqStack = new FreqStack()
        freqStack.push(5)
        freqStack.push(7)
        freqStack.push(5)
        freqStack.push(7)
        freqStack.push(4)
        freqStack.push(5)
        freqStack.pop() should equal (5)
        freqStack.pop() should equal (7)
        freqStack.pop() should equal (5)
        freqStack.pop() should equal (4)
    }


}
