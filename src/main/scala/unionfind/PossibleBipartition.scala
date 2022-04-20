package org.sbk.leet
package unionfind


/*
886. Possible Bipartition
https://leetcode.com/problems/possible-bipartition/
 */
class PossibleBipartition {

    def possibleBipartition(n: Int, dislikes: Array[Array[Int]]): Boolean = {
        /*
        Runtime: 1152 ms, faster than 100.00% of Scala online submissions for Possible Bipartition.
        Memory Usage: 67.5 MB, less than 100.00% of Scala online submissions for Possible Bipartition.
         */
        import scala.collection.mutable

        val m = mutable.HashMap[Int, mutable.HashSet[Int]]().withDefaultValue(mutable.HashSet[Int]())

        for(d <- dislikes) {
            m.getOrElseUpdate(d(0), mutable.HashSet[Int]()) += d(1)
            m.getOrElseUpdate(d(1), mutable.HashSet[Int]()) += d(0)
        }

        val colors = Array.fill[Int](n+1)(0)

        def dfs(i: Int, color: Int) : Boolean = {
            if(colors(i) != 0) return colors(i) == color
            colors(i) = color
            m(i).forall(n => dfs(n, -color))
        }

        (1 to n).forall(i => colors(i) != 0 || dfs(i, 1))

    }

}

object PossibleBipartition {

    def main(args: Array[String]): Unit = {
        val pb = new PossibleBipartition()
        println(pb.possibleBipartition(10, Array(Array(1,2),Array(3,4),Array(5,6),Array(6,7),Array(8,9),Array(7,8))))
    }

}