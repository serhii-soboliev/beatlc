package org.sbk.leet
package greedy

/*
11. Container With Most Water
https://leetcode.com/problems/container-with-most-water/
 */
class ContainerWithMostWater {

    def maxArea_(height: Array[Int]): Int = {
        val n = height.length
        (for{i <- 0 until n; j <- i+1 until n} yield (i,j)).map(v => (v._1 min v._2) * (v._2 - v._1)).max
    }

    def maxArea(height: Array[Int]): Int = {
        var (left, right) = (0, height.length-1)
        var m = 0
        while(left < right) {
            val hl = height(left)
            val hr = height(right)
            val area = (right - left) * (hl min hr)
            m = m max area
            if(hl <= hr) left -= 1
            if(hl >= hr) right -= 1
        }
        m
    }

}
