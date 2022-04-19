package org.sbk.leet
package bfs

/*
752. Open the Lock
https://leetcode.com/problems/open-the-lock/
 */
class OpenTheLock {

    def openLock(deadends: Array[String], target: String): Int = {
        import scala.collection.mutable
        import scala.collection.mutable.ArrayBuffer

        def doTurn(s: String, t: (Int, Int)): String = {
            val a = s.toCharArray
            val newC = ((a(t._2).asDigit + t._1) % 10).toString
            a(t._2) = newC(0)
            a.mkString
        }

        val visited = mutable.HashSet[String]() ++ deadends
        val moves = Array((1,0), (1,1), (1,2), (1,3), (9,0), (9,1), (9,2), (9,3))
        val q = mutable.Queue[ArrayBuffer[String]](ArrayBuffer("0000"))
        var turnsCount = 0
        while(q.nonEmpty) {
            val currentTurns = q.dequeue()
            val newTurns = ArrayBuffer[String]()
            for(s <- currentTurns; if !visited.contains(s)) {
                visited += s
                if(s == target) return turnsCount
                moves.foreach(m => newTurns += doTurn(s, m))
            }
            if(newTurns.isEmpty) return -1
            q += newTurns
            turnsCount += 1
        }
        -1
    }

}

object OpenTheLock {

    def main(args: Array[String]): Unit = {
        val w = new OpenTheLock()
        println(w.openLock(Array("0201","0101","0102","1212","2002"), "0202"))
        println(w.openLock(Array("8888"), "0009"))
        println(w.openLock(Array("8887","8889","8878","8898","8788","8988","7888","9888"), "8888"))
    }

}