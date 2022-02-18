package org.sbk.leet
package design

class FreqStack() {
    import scala.collection.mutable
    val freqToInd: mutable.Map[Int, mutable.Stack[Int]] = mutable.Map().withDefaultValue(mutable.Stack())
    val indToFreq: mutable.Map[Int, Int] = mutable.Map().withDefaultValue(0)
    var maxFreq = 0

    def push(x: Int): Unit = {
        if(indToFreq(x) == 0) indToFreq(x) = 1
        else indToFreq(x) += 1
        val v = indToFreq(x)
        freqToInd(v) = freqToInd.getOrElse(v, mutable.Stack())
        freqToInd(v).push(x)
        maxFreq = maxFreq max v
    }

    def pop(): Int = {
        while(freqToInd(maxFreq).isEmpty) maxFreq -= 1
        if(maxFreq <= 0) return -1
        val poped = freqToInd(maxFreq).pop()
        indToFreq(poped) -= 1
        if(indToFreq(poped) == 0) indToFreq.remove(poped)
        poped
    }
}
