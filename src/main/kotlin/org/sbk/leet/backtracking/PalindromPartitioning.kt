package org.sbk.leet.backtracking


/*
131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/
 */
class PalindromePartitioning {

    fun partitionRecursiveBacktracking(s: String): List<List<String>> {

        if(s.isEmpty()) {
            return mutableListOf()
        }

        val accumulator = mutableListOf<List<String>>()

        fun isPalindrome(st: String) : Boolean {
            var i = 0
            var j = st.length-1
            while(i < j) {
                if(st[i++] != st[j--]) {
                    return false
                }
            }
            return true
        }

        for (i in s.indices) {
            val prefix = s.substring(0, i+1)
            if(isPalindrome(prefix)) {
                val suffix = s.substring(i+1)
                if(suffix.isEmpty()) {
                    accumulator += arrayListOf(prefix)
                } else {
                    val res = partitionRecursiveBacktracking(suffix)
                    for (r in res) {
                        val newRes = r.toMutableList()
                        newRes.add(0, prefix)
                        accumulator += newRes
                    }
                }
            }
        }



        return accumulator
    }

    fun partition(s: String): List<List<String>> {
        val len = s.length
        val dp = Array(len) { BooleanArray(len) }
        val result: MutableList<List<String>> = ArrayList()

        fun dfs(start: Int, currentList: MutableList<String>) {
            if (start >= s.length) result.add(ArrayList(currentList))
            for (end in start until s.length) {
                if (s[start] == s[end] && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true
                    currentList.add(s.substring(start, end + 1))
                    dfs( end + 1, currentList)
                    currentList.removeAt(currentList.size - 1)
                }
            }
        }

        dfs(0, ArrayList())
        return result
    }

    fun dfs(
        result: MutableList<List<String>>,
        s: String,
        start: Int,
        currentList: MutableList<String>,
        dp: Array<BooleanArray>
    ) {
        if (start >= s.length) result.add(ArrayList(currentList))
        for (end in start until s.length) {
            if (s[start] == s[end] && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true
                currentList.add(s.substring(start, end + 1))
                dfs(result, s, end + 1, currentList, dp)
                currentList.removeAt(currentList.size - 1)
            }
        }
    }


}



fun main() {
    val l = mutableListOf<Int>(2, 3, 4)
    l.add(0, 1)
    println(l)
}