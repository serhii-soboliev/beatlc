package org.sbk.leet.backtracking
import java.util.*


/*
216. Combination Sum III
https://leetcode.com/problems/combination-sum-iii/
 */
class CombinationSumIII {

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {

        class Rec(val index: Int, val combinationSum:Int, val currentCombination: List<Int>)

        val accumulator = mutableListOf<List<Int>>()
        val currentCombination = mutableListOf<Int>()
        val index = 1
        val combinationSum = 0
        val q: Queue<Rec> = LinkedList()
        q.add(Rec(index, combinationSum, currentCombination))
        while (q.isNotEmpty()) {
            val r = q.remove()
            if (r.combinationSum == n && r.currentCombination.size == k) {
                accumulator += r.currentCombination
            } else {
                for (i in r.index..9) {
                    if (combinationSum + i > n) {
                        break
                    }
                    val newCurrentCombination = r.currentCombination.toMutableList()
                    newCurrentCombination += i
                    q.add(Rec(i + 1, r.combinationSum + i, newCurrentCombination))
                }
            }
        }
        return accumulator
    }

    fun combinationSum3Recursive(k: Int, n: Int): List<List<Int>> {

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