package org.sbk.leet.backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class WordSearchTest {

    @Test
    fun test_exist_1() {
        val arr = arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E')
        )
        assertTrue(WordSearch().exist(arr, "ABCCED"))
    }

    @Test
    fun test_exist_2() {
        val arr = arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E')
        )
        assertTrue(WordSearch().exist(arr, "SEE"))
    }

    @Test
    fun test_exist_3() {
        val arr = arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E')
        )
        assertFalse(WordSearch().exist(arr, "ABCB"))
    }
}