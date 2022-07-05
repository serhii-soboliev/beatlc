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
        val q: Queue<BooleanArray> = LinkedList()
        q.add(BooleanArray(10){ false })
        var count = 0
        while(q.isNotEmpty()) {
            val r = q.remove()
            val digitsUsed = r.count{ it }
            if(digitsUsed <= n) {
                count += 1
                if(digitsUsed == n) {
                    continue
                }
            }
            if(digitsUsed > 0 && !r[0]) {
                r[0] = true
                q += r.copyOf()
                r[0] = false
            }
            for(i in 1..9) {
                if(!r[i]){
                    r[i] = true
                    q += r.copyOf()
                    r[i] = false
                }
            }
        }
        return count
    }

}