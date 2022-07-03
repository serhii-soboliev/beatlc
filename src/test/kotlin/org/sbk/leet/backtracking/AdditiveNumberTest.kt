package org.sbk.leet.backtracking

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class AdditiveNumberTest {

    @Test
    fun testIsAdditiveNumber() {
        assertTrue(AdditiveNumber().isAdditiveNumber("112358"))
        assertTrue(AdditiveNumber().isAdditiveNumber("199100199"))
        assertFalse(AdditiveNumber().isAdditiveNumber("111"))
    }
}