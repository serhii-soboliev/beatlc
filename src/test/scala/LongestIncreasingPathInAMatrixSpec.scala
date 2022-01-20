package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec


class LongestIncreasingPathInAMatrixSpec extends AnyFlatSpec {

    "A LongestIncreasingPathInAMatrix" should "return 4" in {
        val testInstance = new LongestIncreasingPathInAMatrix
        val res = testInstance.longestIncreasingPath(
            Array(Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))
        )
        assert(res === 4)
    }

    "A LongestIncreasingPathInAMatrix DFS" should "return 4(2)" in {
        val testInstance = new LongestIncreasingPathInAMatrix
        val res = testInstance.longestIncreasingPath(
            Array(Array(3, 4, 5), Array(3, 2, 6), Array(2, 2, 1))
        )
        assert(res === 4)
    }

    "A LongestIncreasingPathInAMatrix DFS" should "return 4" in {
        val testInstance = new LongestIncreasingPathInAMatrix
        val res = testInstance.longestIncreasingPathDFS(
            Array(Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))
        )
        assert(res === 4)
    }

    "A LongestIncreasingPathInAMatrix" should "return 4(2)" in {
        val testInstance = new LongestIncreasingPathInAMatrix
        val res = testInstance.longestIncreasingPathDFS(
            Array(Array(3, 4, 5), Array(3, 2, 6), Array(2, 2, 1))
        )
        assert(res === 4)
    }


}



