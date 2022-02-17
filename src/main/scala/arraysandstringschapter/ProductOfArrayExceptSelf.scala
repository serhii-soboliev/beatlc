package org.sbk.leet
package arraysandstringschapter

/*
https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/827/
 */
class ProductOfArrayExceptSelf {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        val zeroCount = nums.count(n => n == 0)
        val p = nums.filter(n => n != 0).product
        nums.map(n => calc(n, zeroCount, p))
    }

    def calc(n: Int, zeroCount: Int, p: Int) : Int = {
        if (zeroCount > 1) 0
        else if (zeroCount == 1 && n == 0) p
        else if (zeroCount == 1 && n != 0) 0
        else p / n
    }
}
