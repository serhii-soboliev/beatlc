package org.sbk.leet
package design

/*
895. Maximum Frequency Stack
https://leetcode.com/problems/maximum-frequency-stack/
 */
class FreqStackNaive {

    import scala.collection.mutable.ListBuffer
    import scala.collection.mutable

    private val stack = new ListBuffer[Int]()
    private val entryFreq = new mutable.HashMap[Int, Int]()
    private val freqMap = new mutable.HashMap[Int, ListBuffer[Int]]().withDefaultValue(new ListBuffer[Int]())
    private val valuesIndexesMap = new mutable.HashMap[Int, ListBuffer[Int]]().withDefaultValue(new ListBuffer[Int]())

    private var maxFreq = 0

    def push(v: Int): Unit = {
        stack += v
        val idx = stack.length-1
        val oldFreq = entryFreq.getOrElse(v, 0)
        val newFreq = oldFreq + 1
        entryFreq(v) = newFreq
        maxFreq = newFreq max maxFreq
        freqMap.get(oldFreq).map(e => e -= v)
        freqMap(newFreq) = freqMap.getOrElse(newFreq, new ListBuffer()) += v
        valuesIndexesMap(v) = valuesIndexesMap.getOrElse(v,new ListBuffer[Int]) += idx
    }

    def pop(): Int = {
        val mostFrequent = freqMap(maxFreq)
        val tt = mostFrequent.flatMap(mf => valuesIndexesMap(mf))
        val indexToRemove = tt.max
        val valToRemove = stack(indexToRemove)
        entryFreq(valToRemove) -= 1
        valuesIndexesMap.get(valToRemove).map(e => e -= indexToRemove)
        freqMap.get(maxFreq).map(e => e -= valToRemove)
        freqMap.get(maxFreq - 1).map(e => e += valToRemove)
        maxFreq = entryFreq.valuesIterator.max
        stack(indexToRemove) = -1
        valToRemove
    }
}
