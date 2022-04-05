package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShortestPathInBinaryMatrixSpec extends AnyFlatSpec with Matchers {

    "ShortestPathInBinaryMatrix #1" should "2" in {
        val ti = new ShortestPathInBinaryMatrix()
        ti.shortestPathBinaryMatrix(Array(Array(0,1), Array(1,0))) should be (2)
    }

    "ShortestPathInBinaryMatrix #2" should "4" in {
        val ti = new ShortestPathInBinaryMatrix()
        ti.shortestPathBinaryMatrix(Array(Array(0,0,0),Array(1,1,0),Array(1,1,0))) should be (4)
    }

    "ShortestPathInBinaryMatrix #3" should "-1" in {
        val ti = new ShortestPathInBinaryMatrix()
        ti.shortestPathBinaryMatrix(Array(Array(1,0,0),Array(1,1,0),Array(1,1,0))) should be (-1)
    }


}
