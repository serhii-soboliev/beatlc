package org.sbk.leet
package hashtables

/*
997. Find the Town Judge
https://leetcode.com/problems/find-the-town-judge/
 */
class FindTheTownJudge {

    def findJudge(n: Int, trust: Array[Array[Int]]): Int = {
        val m1 = trust.groupBy(_(1)).view.mapValues(_.map(_(0)).length).toMap
        val m2 = trust.groupBy(_(0)).view.mapValues(_.map(_(1)).length).toMap
        val judges = (1 to n).filter(i => m1.contains(i) && m1(i) == n-1 && !m2.contains(i))
        if (judges.length == 1) judges(0) else -1
    }
}

object FindTheTownJudge {

    def main(args: Array[String]): Unit = {
        val w = new FindTheTownJudge()
        println(w.findJudge(3, Array(Array(1, 3), Array(2, 3))))
    }

}
