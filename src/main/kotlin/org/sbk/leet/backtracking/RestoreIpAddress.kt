package org.sbk.leet.backtracking

import java.lang.Integer.min

/*
93. Restore IP Addresses
https://leetcode.com/problems/restore-ip-addresses/
 */
class RestoreIpAddress {

    fun restoreIpAddresses(s1: String): List<String> {

        val validStrings = IntRange(0, 255).map { i -> i.toString() }

        fun backtrack(s: String, n: Int ) : List<String> {
            if(s.isEmpty()){
                return mutableListOf()
            }
            if(n == 1) {
                if(!validStrings.contains(s)) {
                    return mutableListOf()
                }
                return mutableListOf(s)
            }
            val result = mutableListOf<String>()
            val prefixMaxLen = min(4, s.length)
            for(i in 1..prefixMaxLen) {
                val prefix = s.substring(0, i)
                if(!validStrings.contains(prefix)) {
                    continue
                }

                val suffix = s.substring(i)
                val tempRes = backtrack(suffix, n-1)
                for(t in tempRes) {
                    result += "$prefix.$t"
                }
            }

            return result
        }

        return backtrack(s1, 4)
    }

}