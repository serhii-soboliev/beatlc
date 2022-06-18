package org.sbk.leet.backtracking

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test


internal class PermutationsllTest {

    @Test
    fun testPermuteUnique1() {
        val res = Permutationsll().permuteUnique(intArrayOf(1, 2, 3))
        assertThat(res, hasSize(6))
        assertThat(res, containsInAnyOrder(
                arrayListOf(1, 2, 3),
                arrayListOf(1, 3, 2),
                arrayListOf(2, 1, 3),
                arrayListOf(2, 3, 1),
                arrayListOf(3, 1, 2),
                arrayListOf(3, 2, 1)
        ))
    }

    @Test
    fun testPermuteUnique2() {
        val res = Permutationsll().permuteUnique(intArrayOf(1, 1, 2))
        assertThat(res, hasSize(3))
        assertThat(res, containsInAnyOrder(
                arrayListOf(1, 1, 2),
                arrayListOf(1, 2, 1),
                arrayListOf(2, 1, 1)
        ))
    }

    @Test
    fun testPermuteUnique3() {
        val res = Permutationsll().permuteUnique(intArrayOf(1, 1))
        assertThat(res, hasSize(1))
        assertThat(res, containsInAnyOrder(
                arrayListOf(1, 1)
        ))
    }

}