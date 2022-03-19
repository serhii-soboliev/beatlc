package org.sbk.leet
package contests


class BWC74 {

    def divideArray(nums: Array[Int]): Boolean = {
        val numss = nums.sorted
        var start = numss(0)
        var equalsCnt = 0
        for (n <- numss) {
            if (n == start) {
                equalsCnt += 1
            } else {
                if (equalsCnt % 2 != 0) return false
                start = n
                equalsCnt = 1
            }
        }
        true
    }

    def halveArray(nums: Array[Int]): Int = {
        import scala.collection.mutable
        val sum = nums.sum
        var halfSum: Double = sum
        var opCnt = 0
        val pq =  new mutable.PriorityQueue[Double]()
        nums.foreach(n => pq += n)

        while (halfSum >= sum / 2) {
            val t = pq.dequeue()
            val n = t / 2
            halfSum -= n
            opCnt += 1
            pq += n
        }
        opCnt
    }


    def maximumSubsequenceCount(s: String, p: String): Long = {
        var ans = 0
        var max = 0
        var cnt = 1
        for (i <- 0 until s.length) {
            if (s(i) == p(1)) ans += cnt
            if (s(i) == p(0)) cnt += 1
        }
        max = Math.max(max, ans)
        ans = 0
        cnt = 1

        for (i <- s.length - 1 to 0 by -1) {
            if (s(i) == p(0)) ans += cnt
            if (s(i) == p(1)) cnt += 1
        }
        max = Math.max(max, ans)
        max
    }


}

