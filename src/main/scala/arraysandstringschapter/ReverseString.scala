package org.sbk.leet
package arraysandstringschapter

class ReverseString {
    def reverseString(s: Array[Char]): Unit = {
        for(i <- 0 until s.length / 2) {
            val t = s(i)
            s(i) = s(s.length - 1 - i)
            s(s.length - 1 - i) = t
        }
    }
}
