package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MaxAreaOfIslandSpec extends AnyFlatSpec with Matchers {

    "MaxAreaOfIsland #1" should "6" in {
        val ti = new MaxAreaOfIsland()
        ti.maxAreaOfIsland(Array(
            Array(0,0,1,0,0,0,0,1,0,0,0,0,0),
            Array(0,0,0,0,0,0,0,1,1,1,0,0,0),
            Array(0,1,1,0,1,0,0,0,0,0,0,0,0),
            Array(0,1,0,0,1,1,0,0,1,0,1,0,0),
            Array(0,1,0,0,1,1,0,0,1,1,1,0,0),
            Array(0,0,0,0,0,0,0,0,0,0,1,0,0),
            Array(0,0,0,0,0,0,0,1,1,1,0,0,0),
            Array(0,0,0,0,0,0,0,1,1,0,0,0,0)
        )) should be (6)
    }

    "MaxAreaOfIsland #2" should "0" in {
        val ti = new MaxAreaOfIsland()
        ti.maxAreaOfIsland(Array(
            Array(0,0,0,0,0,0,0,0)
        )) should be (0)
    }

    "MaxAreaOfIsland #3" should "2" in {
        val ti = new MaxAreaOfIsland()
        ti.maxAreaOfIsland(Array(
            Array(0,0,0,0,1,1,0,0)
        )) should be (2)
    }

    "MaxAreaOfIsland #4" should "4" in {
        val ti = new MaxAreaOfIsland()
        ti.maxAreaOfIsland(Array(
            Array(0,0,0,0,1,1,0,0),
            Array(0,0,0,1,1,0,0,0)
        )) should be (4)
    }

    "MaxAreaOfIsland #5" should "4" in {
        val ti = new MaxAreaOfIsland()
        ti.maxAreaOfIsland(Array(
            Array(1,1,0,0,0),
            Array(1,1,0,0,0),
            Array(0,0,0,1,1),
            Array(0,0,0,1,1)
        )) should be (4)
    }

}
