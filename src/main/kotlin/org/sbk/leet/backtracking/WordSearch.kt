package org.sbk.leet.backtracking

/*
79. Word Search
https://leetcode.com/problems/word-search/
 */
class WordSearch {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val (n, m) = Pair(board.size, board.first().size)
        val visited = Array(n) { BooleanArray(m) { false } }

        fun dfs(currentWorldIndex: Int, nextPosition: Pair<Int, Int>, visited: Array<BooleanArray>): Boolean {
            val (i, j) = nextPosition

            if(currentWorldIndex > word.length-1
                || board[i][j] != word[currentWorldIndex]
                || visited[i][j]) {
                return false
            }

            if(currentWorldIndex == word.length - 1) {
                return true
            }

            val newVisited = visited.map { it.copyOf() }.toTypedArray()
            newVisited[i][j] = true

            fun getNei(i: Int, j:Int) : List<Pair<Int, Int>> {
                val res = mutableListOf<Pair<Int, Int>>()
                if(i > 0) res += Pair(i-1, j)
                if(i < n-1) res += Pair(i+1, j)
                if(j > 0) res += Pair(i, j-1)
                if(j < m-1) res += Pair(i, j+1)
                return res
            }

            return getNei(i, j).any { (k, l) -> dfs(currentWorldIndex + 1, Pair(k,l), newVisited )}
        }


        return IntRange(0, n-1)
            .flatMap { i ->
                IntRange(0, m-1)
                    .map { j -> Pair(i, j) }
            }
            .any { (i, j) -> dfs(0, Pair(i, j), visited) }

    }

}