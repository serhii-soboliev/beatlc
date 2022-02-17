package org.sbk.leet
package arraysandstringschapter

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SpiralMatrixSpec extends AnyFlatSpec with Matchers {

    "SpiralMatrixSpec" should "scenario 1" in {

        new SpiralMatrix()
          .spiralOrder(Array(Array(1,2,3,4), Array(5,6,7,8), Array(9,10,11,12))) should
          equal(List(1,2,3,4,8,12,11,10,9,5,6,7))
    }

}
