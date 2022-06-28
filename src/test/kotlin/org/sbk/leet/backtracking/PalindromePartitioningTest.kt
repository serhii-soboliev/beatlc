package org.sbk.leet.backtracking

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PalindromePartitioningTest {

    @Test
    fun partition_1() {
        val res = PalindromePartitioning().partition("aab")
        MatcherAssert.assertThat(res, Matchers.hasSize(2))
        MatcherAssert.assertThat(
            res, Matchers.containsInAnyOrder(
                arrayListOf("a","a","b"),
                arrayListOf("aa","b")
            )
        )
    }

    @Test
    fun partition_2() {
        val res = PalindromePartitioning().partition("a")
        MatcherAssert.assertThat(res, Matchers.hasSize(1))
        MatcherAssert.assertThat(
            res, Matchers.containsInAnyOrder(
                arrayListOf("a")
            )
        )

    }
}