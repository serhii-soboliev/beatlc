package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WaterAndJugProblemSpec extends AnyFlatSpec with Matchers {

    "3,5,4" should "true" in {
        new WaterAndJugProblem().canMeasureWater(3,5,4) should be (true)
    }

    "1,2,3" should "true" in {
        new WaterAndJugProblem().canMeasureWater(1,2,3) should be (true)
    }

    "1,2,3" should "true" in {
        new WaterAndJugProblem().canMeasureWater(2,6,5) should be (true)
    }
}
