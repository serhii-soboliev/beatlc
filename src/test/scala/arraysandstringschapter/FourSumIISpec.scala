package org.sbk.leet
package arraysandstringschapter

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FourSumIISpec extends AnyFlatSpec with Matchers {

    "FourSumIISpec" should "scenario 1" in {

        new FourSumII().fourSumCount(Array(1,2),
            Array(-2,-1),
            Array(-1, 2),
            Array(0,2)) should be (2)

        new FourSumII().fourSumCountSumsCount(Array(1,2),
            Array(-2,-1),
            Array(-1, 2),
            Array(0,2)) should be (2)

        new FourSumII().fourSumCountBigArray(Array(1,2),
            Array(-2,-1),
            Array(-1, 2),
            Array(0,2)) should be (2)

        new FourSumII().fourSumCountNaive(Array(1,2),
            Array(-2,-1),
            Array(-1, 2),
            Array(0,2)) should be (2)
    }

    "FourSumIISpec" should "scenario 2" in {

        new FourSumII().fourSumCount(Array(0),
            Array(0),
            Array(0),
            Array(0)) should be (1)

        new FourSumII().fourSumCountSumsCount(Array(0),
            Array(0),
            Array(0),
            Array(0)) should be (1)

        new FourSumII().fourSumCountBigArray(Array(0),
            Array(0),
            Array(0),
            Array(0)) should be (1)

        new FourSumII().fourSumCountNaive(Array(0),
            Array(0),
            Array(0),
            Array(0)) should be (1)
    }
}
