package org.sbk.leet.backtracking

/*
131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/
 */
class PalindromePartitioning {

    fun partition(s: String): List<List<String>> {

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
                    val res = partition(suffix)
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

}

fun main() {
    val l = mutableListOf<Int>(2, 3, 4)
    l.add(0, 1)
    println(l)
}