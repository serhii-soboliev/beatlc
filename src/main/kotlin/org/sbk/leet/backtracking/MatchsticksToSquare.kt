package org.sbk.leet.backtracking

/*
473. Matchsticks to Square
https://leetcode.com/problems/matchsticks-to-square/
 */
class MatchsticksToSquare {

    fun makesquare(matchsticks: IntArray): Boolean {
        if(matchsticks.isEmpty()) {
            return false
        }
        val s = matchsticks.sum()
        if(s % 4 != 0) {
            return false
        }

        val sideLength = s / 4
        val sums = IntArray(4) { 0 }
        matchsticks.sortDescending()

        fun dfs(i: Int) : Boolean {
            if(i == matchsticks.size) {
                return sums.all { it == sideLength }
            }
            val v = matchsticks[i]
            if(v > sideLength) return false
            for (j in 0 until 4) {
                if (sums[j] + v <= sideLength) {
                    sums[j] += v
                    if (dfs(i+1)) return true
                    sums[j] -= v
                }
            }
            return false
        }
        return dfs(0)
    }

}