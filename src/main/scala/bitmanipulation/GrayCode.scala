package org.sbk.leet
package bitmanipulation

/*
89. Gray Code
https://leetcode.com/problems/gray-code/
https://www.geeksforgeeks.org/generate-n-bit-gray-codes/
 */
class GrayCode {
    def grayCode(n: Int): List[Int] = {
        (0 until 1<<n).map { x => (x >> 1)^x}.toList
    }
}
