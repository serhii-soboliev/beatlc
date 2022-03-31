package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NumberOfEnclavesSpec extends AnyFlatSpec with Matchers {

    "NumberOfEnclaves #1" should "3" in {
        val ti = new NumberOfEnclaves()
        ti.numEnclaves(Array(
            Array(0,0,0,0),
            Array(1,0,1,0),
            Array(0,1,1,0),
            Array(0,0,0,0)
        )) should be (3)
    }

    "NumberOfEnclaves #2" should "0" in {
        val ti = new NumberOfEnclaves()
        ti.numEnclaves(Array(
            Array(0,1,1,0),
            Array(0,0,1,0),
            Array(0,0,1,0),
            Array(0,0,0,0)
        )) should be (0)
    }




}
