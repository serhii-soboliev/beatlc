package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AddBinarySpec extends AnyFlatSpec with Matchers {

    "AddBinary('1111', '110001')" should "1000000" in {
        new AddBinary().addBinary("1111", "110001") shouldEqual "1000000"
    }

    "AddBinary('1111', '1111')" should "11110" in {
        new AddBinary().addBinary("1111", "1111") shouldEqual "11110"
    }

    "AddBinaryIterative('11', '1')" should "100" in {
        new AddBinary().addBinaryIterative("11", "1") shouldEqual "100"
    }

    "AddBinaryIterative('1', '1')" should "10" in {
        new AddBinary().addBinaryIterative("1", "1") shouldEqual "10"
    }

    "AddBinaryIterative('1111', '1111')" should "11110" in {
        new AddBinary().addBinaryIterative("1111", "1111") shouldEqual "11110"
    }

    "AddBinaryIterative('1111', '110001')" should "1000000" in {
        new AddBinary().addBinaryIterative("1111", "110001") shouldEqual "1000000"
    }

}
