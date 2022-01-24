package org.sbk.leet
package bitmanipulation

/*
717. 1-bit and 2-bit Characters
https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */


class OneBitAndTwoBitCharacters {
    def isOneBitCharacter(bits: Array[Int]): Boolean = {
        var currentPosition = 0
        while(currentPosition < bits.length-1) {
            currentPosition += (if(bits(currentPosition) == 0) 1 else 2)
        }
        currentPosition == bits.length - 1
    }
}
