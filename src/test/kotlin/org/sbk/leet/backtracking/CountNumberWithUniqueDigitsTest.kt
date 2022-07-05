package org.sbk.leet.backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CountNumberWithUniqueDigitsTest {

    @Test
    fun testCountNumbersWithUniqueDigits() {
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigits(2), 91)
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigits(0), 1)
    }
}