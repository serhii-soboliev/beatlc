package org.sbk.leet
package dfs


/*
365. Water and Jug Problem
https://leetcode.com/problems/water-and-jug-problem/
 */
class WaterAndJugProblem {

    def canMeasureWaterGCD(j1: Int, j2: Int, t: Int): Boolean = {
        import scala.annotation.tailrec

        @tailrec
        def gcd(a: Int, b:Int):Int = {
            a match {
                case 0 => b
                case _ => gcd(b%a, a)
            }
        }

        t % gcd(j1, j2) == 0 && t < j1 + j2
    }

    def canMeasureWater(j1: Int, j2: Int, t: Int): Boolean = {
        import scala.collection.mutable

        val visited = mutable.Set[(Int, Int)]((0, 0))
        val q = mutable.Queue[(Int, Int)]((0, 0))
        while(q.nonEmpty) {
            val (x,y) = q.dequeue()
            visited += Tuple2(x,y)
            if(x + y == t) return true
            val newStates = mutable.Set[(Int, Int)]()
            newStates += Tuple2(j1, y)
            newStates += Tuple2(0, y)
            newStates += Tuple2(x, j2)
            newStates += Tuple2(x, 0)
            newStates += Tuple2(j1 min (x + y), if (x + y <= j1) 0 else y - (j1 -x))
            newStates += Tuple2(if(x + y <= j2) 0 else x - (j2 - y), j2 min (y + x))
            for(newState <- newStates; if !visited.contains(newState)) q += newState
        }
        false
    }

}

object WaterAndJugProblem {
    def main(args: Array[String]): Unit = {
        val w = new WaterAndJugProblem()
        println(w.canMeasureWater(3,5,4))
        println(w.canMeasureWater(2,6,5))
        println(w.canMeasureWater(1,2,3))
    }
}
