package org.sbk.leet.backtracking

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CombinationSumIIITest {

    @Test
    fun combinationSum3_1() {
        val res = CombinationSumIII().combinationSum3(3, 7)
        MatcherAssert.assertThat(res, Matchers.hasSize(1))
        MatcherAssert.assertThat(res, Matchers.containsInAnyOrder(
            arrayListOf(1,2,4)
        ))
    }

    @Test
    fun combinationSum3_2() {
        val res = CombinationSumIII().combinationSum3(3, 9)
        MatcherAssert.assertThat(res, Matchers.hasSize(3))
        MatcherAssert.assertThat(res, Matchers.containsInAnyOrder(
            arrayListOf(1,2,6),
            arrayListOf(1,3,5),
            arrayListOf(2,3,4)
        ))
    }

    @Test
    fun combinationSum3_3() {
        val res = CombinationSumIII().combinationSum3(4, 1)
        MatcherAssert.assertThat(res, Matchers.hasSize(0))
    }

    @Test
    fun combinationSum3_4() {
        val res = CombinationSumIII().combinationSum3(9, 45)
        MatcherAssert.assertThat(res, Matchers.hasSize(1))
        MatcherAssert.assertThat(res, Matchers.containsInAnyOrder(
            arrayListOf(1,2,3,4,5,6,7,8,9)
        ))
    }
}