package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ShortestBridgeSpec extends AnyFlatSpec with Matchers {

    "ShortestBridge #1" should "1" in {
        val ti = new ShortestBridge()
        ti.shortestBridge(Array(
            Array(0,1),
            Array(1,0)
        )) should be (1)
    }

    "ShortestBridge #2" should "2" in {
        val ti = new ShortestBridge()
        ti.shortestBridge(Array(
            Array(0,1,0),
            Array(0,0,0),
            Array(0,0,1)
        )) should be (2)
    }

    "ShortestBridge #3" should "1" in {
        val ti = new ShortestBridge()
        ti.shortestBridge(Array(
            Array(1,1,1,1,1),
            Array(1,0,0,0,1),
            Array(1,0,1,0,1),
            Array(1,0,0,0,1),
            Array(1,1,1,1,1)
        )) should be (1)
    }
}
