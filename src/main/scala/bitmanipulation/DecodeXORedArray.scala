package org.sbk.leet
package bitmanipulation

/*
   1720. Decode XORed Array
   https://leetcode.com/problems/decode-xored-array/
 */

class DecodeXORedArray {

    def decodeFunctional(encoded: Array[Int], first: Int): Array[Int] = {
        var r = Array(first)
        encoded.foreach{i => r = r:+(r.last ^ i)}
        r
    }

    def decodeIterative(encoded: Array[Int], first: Int): Array[Int] = {
        import scala.collection.mutable.ArrayBuffer
        val res = ArrayBuffer(first)
        for(i <- 1 to encoded.length) {
            res += res(i-1) ^ encoded(i-1)
        }
        res.toArray
    }
}
