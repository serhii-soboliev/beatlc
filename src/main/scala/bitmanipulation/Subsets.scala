package org.sbk.leet
package bitmanipulation


/*
    78. Subsets
    https://leetcode.com/problems/subsets/
 */

class Subsets {

    def subsets(nums: Array[Int]): List[List[Int]] = {
        if (nums.isEmpty) return List(List())
        val next = subsets(nums.tail)
        next ::: next.map(_ :+ nums.head)
    }

    def subsetsBitManipulation(nums: Array[Int]): List[List[Int]] = {

        def createPermutation(a: Array[Int], n: Int): List[Int] = {

            def isSet(n: Int, k: Int) : Boolean = ((n >> k) & 1) > 0

            a.zipWithIndex
              .filter{ case (_,i) => isSet(n, i)}
              .map{ case (v,i) => v}
              .toList
        }

        val k = scala.math.pow(2, nums.length).toInt
        (0 until k).map(i => createPermutation(nums, i)).distinct.toList
    }

}
