package org.sbk.leet.backtracking

/*
216. Combination Sum III
https://leetcode.com/problems/combination-sum-iii/
 */
class CombinationSumIII {

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {

        val accumulator = mutableListOf<List<Int>>()

        fun backtrack(k: Int, n: Int, start: Int, current: List<Int>) {
            if(k == 0 && n == 0) {
                accumulator += current.toList()
                return
            }
            if(start > 9 || n < 0) {
                return
            }
            val newCurrent = current.toMutableList()
            newCurrent += start
            backtrack(k - 1, n - start, start + 1, newCurrent)
            backtrack(k, n, start + 1, current)
        }

        backtrack(k, n, 1, mutableListOf())

        return accumulator
    }
}