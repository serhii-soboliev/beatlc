package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PacificAtlanticWaterFlowSpec extends AnyFlatSpec with Matchers {

    "PacificAtlanticWaterFlow #1" should "5" in {
        val ti = new PacificAtlanticWaterFlow()
        val r = ti.pacificAtlantic(Array(
            Array(1, 2, 2, 3, 5),
            Array(3, 2, 3, 4, 4),
            Array(2, 4, 5, 3, 1),
            Array(6, 7, 1, 4, 5),
            Array(5, 1, 1, 2, 4)
        ))
        r should contain theSameElementsAs List(List(0,4), List(1,3), List(1,4), List(2,2), List(3,0), List(3,1), List(4,0))
    }

    "PacificAtlanticWaterFlow #2" should "4" in {
        val ti = new PacificAtlanticWaterFlow()
        ti.pacificAtlantic(Array(
            Array(2,1),
            Array(1,2)
        )) should contain theSameElementsAs List(List(0,0), List(1,0), List(0,1), List(1,1))
    }

    "PacificAtlanticWaterFlow #3" should "6" in {
        val ti = new PacificAtlanticWaterFlow()
        ti.pacificAtlantic(Array(
            Array(1,1),
            Array(1,1),
            Array(1,1)
        )) should contain theSameElementsAs List(List(0,0), List(0,1), List(1,0), List(1,1), List(2,0), List(2,1))
    }

    "PacificAtlanticWaterFlow #4" should "6" in {
        val ti = new PacificAtlanticWaterFlow()
        ti.pacificAtlantic(Array(
            Array(1,2,3),
            Array(8,9,4),
            Array(7,6,5)
        )) should contain theSameElementsAs List(List(0,2), List(1,0), List(1,1), List(1,2), List(2,0), List(2,1), List(2,2))
    }

    "PacificAtlanticWaterFlow #5" should "6" in {
        val ti = new PacificAtlanticWaterFlow()
        ti.pacificAtlantic(Array(
            Array(3,3,3,3,3,3),
            Array(3,0,3,3,0,3),
            Array(3,3,3,3,3,3)
        )) should contain theSameElementsAs List(List(0, 0), List(0, 1), List(0, 2), List(0, 3), List(0, 4), List(0, 5), List(1, 0), List(1, 2), List(1, 3), List(1, 5), List(2, 0), List(2, 1), List(2, 2), List(2, 3), List(2, 4), List(2, 5))
    }

}
