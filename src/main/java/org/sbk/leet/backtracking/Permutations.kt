package org.sbk.leet.backtracking

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
            return arrayListOf(nums.toList());
        }

        val result = mutableListOf<List<Int>>()
        val subNums = nums.copyOfRange(0, nums.lastIndex)
        val subPermutations = permute(subNums);
        for(subPermutation in subPermutations) {
            subPermutation.forEachIndexed { i, _ ->
                val newPermutation: MutableList<Int> = subPermutation.toMutableList()
                newPermutation.add(i, nums.last())
                result.add(newPermutation.toList())
            }
            val lastPermutation = subPermutation.toMutableList();
            lastPermutation.add(nums.last())
            result.add(lastPermutation)
        }

        return result.toList()
    }
}

fun main(args: Array<String>) {
    println(Permutations().permute(intArrayOf(1,2,3)))
}