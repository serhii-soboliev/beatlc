package org.sbk.leet.backtracking

import java.util.*

/*
47. Permutations II
https://leetcode.com/problems/permutations-ii/
 */
class Permutationsll {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val counter: SortedMap<Int, Int> = nums.toList().groupingBy { it }.eachCount().toSortedMap()
        val results = mutableListOf<List<Int>>()

        fun backtrack(current: MutableList<Int>) {
            if(current.size == nums.size) {
                results.add(current.toList())
                return
            }
            for(key in counter.keys) {
                val freq = counter.getOrDefault(key, -1)
                if(freq <= 0) {
                    continue
                }
                counter[key] = freq - 1
                val newCurrent = ArrayList(current).toMutableList()
                newCurrent.add(key)
                backtrack(newCurrent)
                counter[key] = freq

            }
        }
        backtrack(mutableListOf())
        return results
    }

}

fun main() {
    println(Permutationsll().permuteUnique(intArrayOf(1,1,2)))
}