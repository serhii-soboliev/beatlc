package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OneBitAndTwoBitCharactersSpec extends AnyFlatSpec with Matchers{

    "OneBitAndTwoBitCharacters.isOneBitCharacter([1,0,0])" should "true" in {
        new OneBitAndTwoBitCharacters().isOneBitCharacter(Array(1,0,0)) should be (true)
    }

    "OneBitAndTwoBitCharacters.isOneBitCharacter([1,1,1,0])" should "false" in {
        new OneBitAndTwoBitCharacters().isOneBitCharacter(Array(1,1,1,0)) should be (false)
    }

    "OneBitAndTwoBitCharacters.isOneBitCharacter([0,0])" should "true" in {
        new OneBitAndTwoBitCharacters().isOneBitCharacter(Array(0,0)) should be (true)
    }

}
