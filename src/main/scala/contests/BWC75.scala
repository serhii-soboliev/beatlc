package org.sbk.leet
package contests




class BWC75 {

    def minBitFlips(start: Int, goal: Int): Int = {
        (start ^ goal).toBinaryString.toCharArray.count(c => c == '1')
    }

    def minBitFlips_(start: Int, goal: Int): Int = {
        val s1 = String.format("%64s", Integer.toBinaryString(start)).replace(' ', '0').toCharArray
        val s2 = String.format("%64s", Integer.toBinaryString(goal)).replace(' ', '0').toCharArray
        var res = 0
        for(i <- s1.indices) {
            if(s1(i) != s2(i)) res += 1
        }
        res
    }

    def triangularSum(nums: Array[Int]): Int = {
        var l = nums.length
        while(l > 1) {
            for(i <- 0 until l-1) {
                nums(i) = (nums(i) + nums(i + 1)) % 10
            }
            l -= 1
        }
        nums(0)
    }

    def numberOfWays(s: String): Long = {
        val totalZeros = s.count(c => c == '0')
        val totalOnes = s.length - totalZeros
        var curZeros = if(s(0) == '0') 1 else 0
        var curOnes = 1 - curZeros
        s.slice(1, s.length-1).map(c => {
            var r: Long = 0
            if(c == '1') {
                curOnes += 1
                r = curZeros * (totalZeros - curZeros)
            } else {
                curZeros += 1
                r = curOnes * (totalOnes - curOnes)
            }
            r
        }).sum
    }
}

object BWC75 {
    def main(args: Array[String]): Unit = {
        val c = new BWC75()
        println(c.numberOfWays("11100"))
        println(c.numberOfWays("001101"))
    }
}

