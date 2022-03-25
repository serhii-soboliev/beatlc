package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FloodFillSpec extends AnyFlatSpec with Matchers {

    "FloodFill" should "scenario #1" in {
        val ti = new FloodFill()
        ti.floodFill(Array(Array(1,1,1),Array(1,1,0),Array(1,0,1)), 1, 1, 2) should
                        equal (Array(Array(2,2,2),Array(2,2,0),Array(2,0,1)))
    }

    "FloodFill" should "scenario #2" in {
        val ti = new FloodFill()
        ti.floodFill(Array(Array(0,0,0),Array(1,1,1)), 1, 1, 1) should
          equal (Array(Array(0, 0, 0), Array(1, 1, 1)))
    }

}
