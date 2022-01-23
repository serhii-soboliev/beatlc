package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AddBinarySpec extends AnyFlatSpec with Matchers{

    "AddBinary('11', '1')" should "100" in {
        new AddBinary().addBinary("11", "1") shouldEqual "100"
    }

    "AddBinary('1', '1')" should "10" in {
        new AddBinary().addBinary("1", "1") shouldEqual "10"
    }

    "AddBinary('1111', '1111')" should "11110" in {
        new AddBinary().addBinary("1111", "1111") shouldEqual "11110"
    }

}
