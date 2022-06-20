package org.sbk.leet.backtracking

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CombinationsTest {

    @Test
    fun test_combine_1() {
        val res = Combinations().combine(4, 2)
        MatcherAssert.assertThat(res, Matchers.hasSize(6))
        MatcherAssert.assertThat(res, Matchers.containsInAnyOrder(
                arrayListOf(1, 2),
                arrayListOf(1, 3),
                arrayListOf(1, 4),
                arrayListOf(2, 3),
                arrayListOf(2, 4),
                arrayListOf(3, 4)
        ))

    }

    @Test
    fun test_combine_2() {
        val res = Combinations().combine(1, 1)
        MatcherAssert.assertThat(res, Matchers.hasSize(1))
        MatcherAssert.assertThat(res, Matchers.containsInAnyOrder(
                arrayListOf(1)
        ))
    }
}