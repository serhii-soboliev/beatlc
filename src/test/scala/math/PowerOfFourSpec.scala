package org.sbk.leet
package math


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class PowerOfFourSpec extends AnyFlatSpec with Matchers {

    "PowerOfFour" should "equal value" in {
        new PowerOfFour().isPowerOfFour(-1) should be (false)
        new PowerOfFour().isPowerOfFour(0) should be (false)
        new PowerOfFour().isPowerOfFour(1) should be (true)
        new PowerOfFour().isPowerOfFour(17) should be (false)
        new PowerOfFour().isPowerOfFour(16) should be (true)
        new PowerOfFour().isPowerOfFour(64) should be (true)
        new PowerOfFour().isPowerOfFour(71) should be (false)
    }


}
