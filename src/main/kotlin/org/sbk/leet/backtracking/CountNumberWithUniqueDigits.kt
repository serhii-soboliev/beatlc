package org.sbk.leet.backtracking

import java.util.*
import kotlin.collections.HashSet

/*
357. Count Numbers with Unique Digits
https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
class CountNumberWithUniqueDigits {

    fun countNumbersWithUniqueDigits(n: Int): Int {
        if(n == 0) return 1
        var temp = 9
        var res = 10
        for(i in 1 until n) {
            temp *= (10 - i)
            res += temp
        }
        return res
    }

    fun countNumbersWithUniqueDigitsBFS(n: Int): Int {
        if(n == 0) return 1
        val q: Queue<Set<Int>> = LinkedList()
        q.add(HashSet())
        var count = 0
        while(q.isNotEmpty()) {
            val r = q.remove()
            if(r.size <= n) {
                count += 1
                if(r.size == n) {
                    continue
                }
            }
            if(r.isNotEmpty() && !r.contains(0)) {
                val newR = r.toHashSet()
                newR += 0
                q += newR
            }
            for(i in 1..9) {
                if(!r.contains(i)){
                    val newR = r.toHashSet()
                    newR += i
                    q += newR
                }
            }
        }
        return count
    }

}