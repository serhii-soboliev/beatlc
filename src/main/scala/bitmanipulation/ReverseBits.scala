package org.sbk.leet
package bitmanipulation

/*
190. Reverse Bits
https://leetcode.com/problems/reverse-bits/
 */
class ReverseBits {
    def reverseBits(x: Int): Int = {
        (0 to 31)
          .map(i => ((x >> i) & 1) << (31 - i))
          .sum
    }

}
