package org.sbk.leet.backtracking

import org.scalactic.Bool

/*
46. Permutations
https://leetcode.com/problems/permutations/
 */
class Permutations {

    fun permute(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()) {
            return arrayListOf()
        }
        if(nums.size == 1) {
            return arrayListOf(nums.toList())
        }


        fun dfs(nums: IntArray, result: MutableList<List<Int>>, current: MutableList<Int>, visited: BooleanArray) {
            if(current.size == nums.size) {
                result.add(current.toList())
                return
            }
            for(i in nums.indices) {
                if(visited[i]) {
                    continue
                }
                visited[i] = true
                current.add(nums[i])
                dfs(nums, result, current, visited)
                visited[i] = false
                current.removeLast()
            }
        }

        val result = mutableListOf<List<Int>>()
        dfs(nums, result, mutableListOf(), BooleanArray(nums.size) { false })
        return result
    }


    fun permuteRecursive(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()) {
            return arrayListOf()
        }
        if(nums.size == 1) {
            return arrayListOf(nums.toList())
        }

        val result = mutableListOf<List<Int>>()
        val subNums = nums.copyOfRange(0, nums.lastIndex)
        val subPermutations = permuteRecursive(subNums)
        for(subPermutation in subPermutations) {
            subPermutation.forEachIndexed { i, _ ->
                val newPermutation: MutableList<Int> = subPermutation.toMutableList()
                newPermutation.add(i, nums.last())
                result.add(newPermutation.toList())
            }
            val lastPermutation = subPermutation.toMutableList()
            lastPermutation.add(nums.last())
            result.add(lastPermutation)
        }

        return result.toList()
    }
}

fun main() {
    println(Permutations().permute(intArrayOf(1,2,3)))
}