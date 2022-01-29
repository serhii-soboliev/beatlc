package org.sbk.leet
package bitmanipulation


/*
  405. Convert a Number to Hexadecimal
  https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
class ConvertNumberToHexadecimal {

    def toHex(num: Int): String = {

        val lookup = Array('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f')

        def hex(num: Long): String = {
            if(num == 0) "" else {
                val q = num / 16
                val r = (num % 16).toInt
                hex(q) + lookup(r)
            }
        }

        if(num == 0) "0"
        else if (num > 0)  {
            hex(num)
        } else {
            val twosComplement = num + Math.pow(2, 32).toLong
            hex(twosComplement)
        }
    }

}
