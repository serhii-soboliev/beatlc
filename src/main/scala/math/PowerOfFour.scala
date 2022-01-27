package org.sbk.leet
package math


/*
342. Power of Four
https://leetcode.com/problems/power-of-four/
 */
class PowerOfFour {
    def isPowerOfFour(n: Int): Boolean = {
        val l = Math.log(n) / Math.log(4)
        l == Math.round(l)
    }


}
