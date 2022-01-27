package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class ReverseBitsSpec extends AnyFlatSpec with Matchers {

    "ReverseBits.reverse()" should "equal 964176192" in {
        new ReverseBits().reverseBits(43261596) should equal (964176192)
    }

}
