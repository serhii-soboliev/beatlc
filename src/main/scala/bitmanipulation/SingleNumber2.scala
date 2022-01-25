package org.sbk.leet
package bitmanipulation

/*
137. Single Number II
https://leetcode.com/problems/single-number-ii/
https://baihuqian.github.io/2018-06-23-single-number-ii/
 */
class SingleNumber2 {
    def singleNumber(nums: Array[Int]): Int = {
        var ones = 0
        var twos = 0
        for (n <- nums) {
            ones = (ones ^ n) & ~twos
            twos = (twos ^ n) & ~ones
        }
        ones
    }
}
