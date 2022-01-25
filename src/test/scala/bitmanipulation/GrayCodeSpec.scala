package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GrayCodeSpec extends AnyFlatSpec with Matchers{
    "GreyCode.greyCode(2)" should "[0,1,3,2]" in {
        new GrayCode().grayCode(2) == List(0, 1, 3, 2)
    }
}
