package org.sbk.leet
package bitmanipulation

/*
   1720. Decode XORed Array
   https://leetcode.com/problems/decode-xored-array/
 */

class DecodeXORedArray {
    def decodeIterative(encoded: Array[Int], first: Int): Array[Int] = {
        import scala.collection.mutable.ArrayBuffer
        val res = ArrayBuffer(first)
        for(i <- 1 to encoded.length) {
            res += res(i-1) ^ encoded(i-1)
        }
        res.toArray
    }
}
