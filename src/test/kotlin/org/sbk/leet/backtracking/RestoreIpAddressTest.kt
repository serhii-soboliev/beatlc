package org.sbk.leet.backtracking

import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test

internal class RestoreIpAddressTest {

    @Test
    fun testRestoreIpAddress1() {
        val res = RestoreIpAddress().restoreIpAddresses("25525511135")
        MatcherAssert.assertThat(
            res, Matchers.containsInAnyOrder(
                "255.255.11.135",
                "255.255.111.35"
            )
        )
    }

    @Test
    fun testRestoreIpAddress2() {
        val res = RestoreIpAddress().restoreIpAddresses("0000")
        MatcherAssert.assertThat(
            res, Matchers.containsInAnyOrder(
                "0.0.0.0"
            )
        )
    }

    @Test
    fun testRestoreIpAddress3() {
        val res = RestoreIpAddress().restoreIpAddresses("101023")
        MatcherAssert.assertThat(
            res, Matchers.containsInAnyOrder(
                "1.0.10.23",
                "1.0.102.3",
                "10.1.0.23",
                "10.10.2.3",
                "101.0.2.3"
            )
        )
    }
}