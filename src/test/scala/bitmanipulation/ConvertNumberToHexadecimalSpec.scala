package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers



class ConvertNumberToHexadecimalSpec extends AnyFlatSpec with Matchers{

    "ConvertNumberToHexadecimal.hex(0)" should "[0]" in {
        new ConvertNumberToHexadecimal().toHex(0) should equal ("0")
        new ConvertNumberToHexadecimal().toHex(15) should equal ("f")
        new ConvertNumberToHexadecimal().toHex(-33) should equal ("ffffffdf")
    }



}
