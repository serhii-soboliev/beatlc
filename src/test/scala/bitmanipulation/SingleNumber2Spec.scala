package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SingleNumber2Spec extends AnyFlatSpec with Matchers{

    ignore should "-4" in {
        new SingleNumber2().singleNumber(Array(-2,-2,1,1,4,1,4,4,-4,-2)) should equal (-4)
    }

    "SingleNumber2.singleNumber(Array(2,2,3,2))" should "3" in {
        new SingleNumber2().singleNumber(Array(2,2,3,2)) should equal (3)
    }

    "SingleNumber2.singleNumber(Array(0,1,0,1,0,1,99))" should "99" in {
        new SingleNumber2().singleNumber(Array(0,1,0,1,0,1,99)) should equal (99)
    }

    "SingleNumber2.singleNumberKarnaughMap(Array(2,2,3,2))" should "3" in {
        new SingleNumber2().singleNumberKarnaughMap(Array(2,2,3,2)) should equal (3)
    }

    "SingleNumber2.singleNumberKarnaughMap(Array(0,1,0,1,0,1,99))" should "99" in {
        new SingleNumber2().singleNumberKarnaughMap(Array(0,1,0,1,0,1,99)) should equal (99)
    }

}
