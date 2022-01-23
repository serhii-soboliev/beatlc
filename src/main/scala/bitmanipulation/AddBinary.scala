package org.sbk.leet
package bitmanipulation

/*
67. Add Binary
https://leetcode.com/problems/add-binary/
 */
class AddBinary {

    def addBinary(a: String, b: String): String = {

        def addChar(c1: Char, c2: Char,c3: Char): String = {
            (c1,c2,c3) match {
                case ('1','1','1') => "11"
                case ('0','0','0') => "00"
                case ('1','0','1') => "10"
                case ('1','1','0') => "10"
                case ('0','1','1') => "10"
                case _ => "01"
            }
        }

        @annotation.tailrec
        def add(l1: List[Char], l2: List[Char], s: String): String = {
            (l1,l2) match {
                case (Nil,Nil) => s
                case (h1::t1,Nil) => add(t1,l2,addChar(h1,s(0),'0') + s.tail)
                case (Nil,h2::t2) => add(l1,t2,addChar(h2,s(0),'0') + s.tail)
                case (h1::t1,h2::t2) => add(t1,t2,addChar(h1,h2,s(0)) + s.tail)
            }
        }

        val s = add(a.reverse.toList,b.reverse.toList,"0").dropWhile(_=='0')
        if (s.isEmpty) "0"
        else s
    }

    def addBinaryIterative(as: String, bs: String): String = {
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