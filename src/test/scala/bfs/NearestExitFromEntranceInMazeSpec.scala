package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NearestExitFromEntranceInMazeSpec extends AnyFlatSpec with Matchers {

    "NearestExitFromEntranceInMaze" should "scenario #1" in {
        val ti = new NearestExitFromEntranceInMaze()
        ti.nearestExit(Array(
            Array('.','.','+'),
            Array('+','.','+'),
            Array('+','.','.')
        ), Array(2,2)) should be(1)
    }
}
