package org.sbk.leet
package bitmanipulation

/*
67. Add Binary
https://leetcode.com/problems/add-binary/
 */
class AddBinary {

    def addBinary(as: String, bs: String): String = {
        var res = ""
        val d = as.length - bs.length
        var an = as
        var bn = bs
        if (d < 0) {
            an = "0" * (-d) + an
        }
        if (d > 0) {
            bn = "0" * d + bn
        }
        var toRemember:Character = '0'
        for ((a, b) <- an.reverse zip bn.reverse) {
            val cnt = Array(a, b, toRemember).count(_ == '1')
            cnt match {
                case 0 =>
                    res = "0" + res
                    toRemember = '0'
                case 1 =>
                    res = "1" + res
                    toRemember = '0'
                case 2 =>
                    res = "0" + res
                    toRemember = '1'
                case 3 =>
                    res = "1" + res
                    toRemember = '1'
            }
        }
        if (toRemember == '1') {
            res =  "1" + res
        }
        res
    }

}