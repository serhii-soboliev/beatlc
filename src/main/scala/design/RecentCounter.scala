package org.sbk.leet
package design


/*
933. Number of Recent Calls
https://leetcode.com/problems/number-of-recent-calls/
 */
class RecentCounter {

    import scala.collection.mutable.ListBuffer
    val n = 3000
    var range = new ListBuffer[Int]()
    def ping(t: Int): Int = {
        range = range += t
        range.dropWhileInPlace(_ < t - n)
        range.size
    }
}
