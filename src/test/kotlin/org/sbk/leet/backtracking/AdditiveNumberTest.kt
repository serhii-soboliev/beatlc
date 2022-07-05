package org.sbk.leet.backtracking

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class AdditiveNumberTest {

    @Test
    fun testIsAdditiveNumberRecursive() {
        assertTrue(AdditiveNumber().isAdditiveNumberRecursive("112358"))
        assertTrue(AdditiveNumber().isAdditiveNumberRecursive("199100199"))
        assertFalse(AdditiveNumber().isAdditiveNumberRecursive("111"))
    }
}