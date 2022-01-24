package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class DecodeXORedArraySpec extends AnyFlatSpec with Matchers{

    "DecodeXORedArray.decode([1,2,3], 1)" should "[1,0,2,1]" in {
        new DecodeXORedArray().decode(Array(1,2,3), 1) shouldEqual Array(1,0,2,1)
    }

    "DecodeXORedArray.decode([6,2,7,3], 4)" should "[4,2,0,7,4]" in {
        new DecodeXORedArray().decode(Array(6,2,7,3), 4) shouldEqual Array(4,2,0,7,4)
    }

    "DecodeXORedArray.decodeFunctional([1,2,3], 1)" should "[1,0,2,1]" in {
        new DecodeXORedArray().decodeFunctional(Array(1,2,3), 1) shouldEqual Array(1,0,2,1)
    }

    "DecodeXORedArray.decodeFunctional([6,2,7,3], 4)" should "[4,2,0,7,4]" in {
        new DecodeXORedArray().decodeFunctional(Array(6,2,7,3), 4) shouldEqual Array(4,2,0,7,4)
    }

    "DecodeXORedArray.decodeArrayIterative([1,2,3], 1)" should "[1,0,2,1]" in {
        new DecodeXORedArray().decodeIterative(Array(1,2,3), 1) shouldEqual Array(1,0,2,1)
    }

    "DecodeXORedArray.decodeArrayIterative([6,2,7,3], 4)" should "[4,2,0,7,4]" in {
        new DecodeXORedArray().decodeIterative(Array(6,2,7,3), 4) shouldEqual Array(4,2,0,7,4)
    }

}
