package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FindTheDifferenceSpec extends AnyFlatSpec with Matchers{

    "FindTheDifference" should "equal value" in {
        new FindTheDifference().findTheDifference("abcd", "abcde") should equal ('e')
        new FindTheDifference().findTheDifference("", "t") should equal ('t')

    }
}
