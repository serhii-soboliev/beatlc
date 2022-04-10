package org.sbk.leet
package stack



/*
682. Baseball Game
https://leetcode.com/problems/baseball-game/
 */
class BaseballGame {

    def calPoints(ops: Array[String]): Int = {
        import scala.collection.mutable.ListBuffer
        val acc = ListBuffer[Int](0)
        for (v<-ops) {
            if (v == "D") acc+=acc.last*2
            else if (v== "C") acc.remove(acc.length-1)
            else if (v=="+") acc += acc.last + acc(acc.length-2)
            else acc += v.toInt
        }
        acc.sum
    }

}
