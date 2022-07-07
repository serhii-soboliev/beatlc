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
        val perimeter = matchsticks.sum()
        if(perimeter % 4 != 0) {
            return false
        }

        val possibleSquareSide = perimeter / 4
        val l = matchsticks.size
        matchsticks.sortDescending()
        val used = BooleanArray(l) {false}

        fun backtrack(idx: Int, currentLength: Int, sidesToCollect: Int) : Boolean {
            if(sidesToCollect == 0) {
                return true
            }

            if(currentLength == possibleSquareSide) {
                return backtrack(0, 0, sidesToCollect - 1)
            }

            if(currentLength > possibleSquareSide || idx >= l) {
                return false
            }

            for (i in idx until l) {
                if(used[i] || i > 0 && !used[i - 1] && matchsticks[i] == matchsticks[i - 1]) continue
                used[i] = true
                if(backtrack(idx + 1, currentLength + matchsticks[i], sidesToCollect)) return true
                used[i] = false
            }

            return false
        }

        return backtrack(0, 0, 3)
    }

    fun makesquareRecursiveBacktrack(matchsticks: IntArray): Boolean {
        if(matchsticks.isEmpty()) {
            return false
        }
        val perimeter = matchsticks.sum()
        if(perimeter % 4 != 0) {
            return false
        }

        val possibleSquareSide = perimeter / 4
        val l = matchsticks.size

        fun backtrack(idx: Int, currentLength: Int, sidesToCollect: Int) : Boolean {
            if(sidesToCollect == 0) {
                return true
            }

            if(currentLength == possibleSquareSide) {
                return backtrack(0, 0, sidesToCollect - 1)
            }

            if(currentLength > possibleSquareSide || idx == l) {
                return false
            }

            if(matchsticks[idx] != 0) {
                val temp = matchsticks[idx]
                matchsticks[idx] = 0
                if(backtrack(idx + 1, currentLength + temp, sidesToCollect)) {
                    return true
                }
                matchsticks[idx] = temp
            }

            if(backtrack(idx + 1, currentLength, sidesToCollect)) {
                return true
            }

            return false
        }

        return backtrack(0, 0, 3)
    }

    fun makesquareDFS(matchsticks: IntArray): Boolean {
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