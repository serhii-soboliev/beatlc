package org.sbk.leet
package bitmanipulation

/*
 389. Find the Difference
 https://leetcode.com/problems/find-the-difference/
 */
class FindTheDifference {
    def findTheDifference(s: String, t: String): Char = {
        (s.toCharArray ++ t.toCharArray).foldLeft(0)(_^_).toChar
    }
}
