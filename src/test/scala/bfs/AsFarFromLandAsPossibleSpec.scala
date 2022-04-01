package org.sbk.leet
package bfs


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AsFarFromLandAsPossibleSpec extends AnyFlatSpec with Matchers {

    "AsFarFromLandAsPossible #1" should "2" in {
        val ti = new AsFarFromLandAsPossible()
        ti.maxDistanceBFS(Array(
            Array(1,0,1),
            Array(0,0,0),
            Array(1,0,1)
        )) should be (2)
    }

    "AsFarFromLandAsPossible #2" should "4" in {
        val ti = new AsFarFromLandAsPossible()
        ti.maxDistanceBFS(Array(
            Array(1,0,0),
            Array(0,0,0),
            Array(0,0,0)
        )) should be (4)
    }
}
