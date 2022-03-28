package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NumberOfClosedIslandsSpec extends AnyFlatSpec with Matchers {

    "NumberOfClosedIslands #1" should "1" in {
        val ti = new NumberOfClosedIslands()
        ti.closedIsland(Array(
            Array(1,1,1,1,1,1,1,0),
            Array(1,0,0,0,0,1,1,0),
            Array(1,0,1,0,1,1,1,0),
            Array(1,0,0,0,0,1,0,1),
            Array(1,1,1,1,1,1,1,0)
        )) should be (2)
    }

    "NumberOfClosedIslands #2" should "5" in {
        val ti = new NumberOfClosedIslands()
        ti.closedIsland(
          Array(
            Array(0,0,1,1,0,1,0,0,1,0),
            Array(1,1,0,1,1,0,1,1,1,0),
            Array(1,0,1,1,1,0,0,1,1,0),
            Array(0,1,1,0,0,0,0,1,0,1),
            Array(0,0,0,0,0,0,1,1,1,0),
            Array(0,1,0,1,0,1,0,1,1,1),
            Array(1,0,1,0,1,1,0,0,0,1),
            Array(1,1,1,1,1,1,0,0,0,0),
            Array(1,1,1,0,0,1,0,1,0,1),
            Array(1,1,1,0,1,1,0,1,1,0))
        ) should be (5)
    }
}
