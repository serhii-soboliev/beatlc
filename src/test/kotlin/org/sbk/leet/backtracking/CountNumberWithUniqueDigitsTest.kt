package org.sbk.leet.backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CountNumberWithUniqueDigitsTest {

    @Test
    fun testCountNumbersWithUniqueDigits() {
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigits(2), 91)
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigits(0), 1)
    }

    @Test
    fun testCountNumbersWithUniqueDigitsBFS() {
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigitsBFS(2), 91)
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigitsBFS(0), 1)
    }

    @Test
    fun testCountNumbersWithUniqueDigitsBacktrack() {
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigitsBacktrack(2), 91)
        assertEquals(CountNumberWithUniqueDigits().countNumbersWithUniqueDigitsBacktrack(0), 1)
    }
}