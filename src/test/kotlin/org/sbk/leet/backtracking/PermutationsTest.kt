package org.sbk.leet.backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasSize


internal class PermutationsTest {

    @Test
    fun testPermuteRecursive() {
        val res = Permutations().permuteRecursive(intArrayOf(1,2,3))
        assertThat(res, hasSize(6))
        assertThat(res, containsInAnyOrder(arrayListOf(1,2,3),
                                           arrayListOf(1,3,2),
                                           arrayListOf(2,1,3),
                                           arrayListOf(2,3,1),
                                           arrayListOf(3,1,2),
                                           arrayListOf(3,2,1)
        ))
    }

    @Test
    fun testPermuteIterative() {
        val res = Permutations().permute(intArrayOf(1,2,3))
        assertThat(res, hasSize(6))
        assertThat(res, containsInAnyOrder(arrayListOf(1,2,3),
                arrayListOf(1,3,2),
                arrayListOf(2,1,3),
                arrayListOf(2,3,1),
                arrayListOf(3,1,2),
                arrayListOf(3,2,1)
        ))
    }
}