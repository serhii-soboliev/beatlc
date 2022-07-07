package org.sbk.leet.backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MatchsticksToSquareTest {

    @Test
    fun testMakeSquare() {

       // assertTrue(MatchsticksToSquare().makesquare(intArrayOf(1,1,2,2,2)))
        assertTrue(MatchsticksToSquare().makesquare(intArrayOf(5,5,5,5,4,4,4,4,3,3,3,3)))
        assertFalse(MatchsticksToSquare().makesquare(intArrayOf(3,3,3,3,4)))
        assertFalse(MatchsticksToSquare().makesquare(intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,6)))

    }

    @Test
    fun testMakeSquareDFS() {

        assertTrue(MatchsticksToSquare().makesquareDFS(intArrayOf(1,1,2,2,2)))
        assertTrue(MatchsticksToSquare().makesquareDFS(intArrayOf(5,5,5,5,4,4,4,4,3,3,3,3)))
        assertFalse(MatchsticksToSquare().makesquareDFS(intArrayOf(3,3,3,3,4)))
        assertFalse(MatchsticksToSquare().makesquareDFS(intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,6)))

    }
}