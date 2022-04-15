package org.sbk.leet
package dynamicprogramming


/*
1654. Minimum Jumps to Reach Home
https://leetcode.com/problems/minimum-jumps-to-reach-home/
 */
class MinimumJumpsToReachHome {

    def minimumJumps(forbidden: Array[Int], a: Int, b: Int, x: Int): Int = {

        import scala.collection.mutable

        val f = mutable.HashSet[Int]() ++ forbidden
        val q = mutable.Queue[(Int, Int, Boolean)]()
        q.addOne((0, 0, true))
        val upper = forbidden.max + a + b + x

        while(q.nonEmpty) {
            val (pos, steps, back) = q.dequeue()
            if(pos == x) return steps
            if(!f.contains(pos-b) && back && pos-b > 0) q.addOne((pos-b, steps+1, false))
            if(!f.contains(pos+a) && pos+a <= upper) q.addOne((pos+a, steps+1, true))
            f += (pos+a)
        }
        -1
    }


}
