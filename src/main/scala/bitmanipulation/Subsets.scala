package org.sbk.leet
package bitmanipulation

import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.collection.mutable

/*
    78. Subsets
    https://leetcode.com/problems/subsets/
 */

class Subsets {

    def subsets(nums: Array[Int]): List[List[Int]] = {

        def createPermutation(a: Array[Int], n: Int): List[Int] = {

            def isSet(n: Int, k: Int) : Boolean = ((1 << k) & n) > 0

            a.zipWithIndex
              .filter{ case (_,i) => isSet(n, i)}
              .map{ case (v,i) => v}
              .toList
        }

        val k = scala.math.pow(2, nums.length).toInt
        (0 until k).map(i => createPermutation(nums, i)).distinct.toList
    }

}
