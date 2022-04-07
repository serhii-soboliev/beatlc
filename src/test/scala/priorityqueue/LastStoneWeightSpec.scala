package org.sbk.leet
package priorityqueue

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LastStoneWeightSpec extends AnyFlatSpec with Matchers {

    "[2,7,4,1,8,1]" should "1" in {
        val ti = new LastStoneWeight()
        ti.lastStoneWeight(Array(2,7,4,1,8,1)) should be (1)
    }
}
