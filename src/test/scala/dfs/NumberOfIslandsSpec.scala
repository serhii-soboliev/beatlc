package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NumberOfIslandsSpec extends AnyFlatSpec with Matchers {

    "NumberOfIslands #1" should "1" in {
        val ti = new NumberOfIslands()
        ti.numIslands(Array(
            Array('1','1','1','1','0'),
            Array('1','1','0','1','0'),
            Array('1','1','0','0','0'),
            Array('0','0','0','0','0')
        )) should be (1)
    }

    "NumberOfIslands #2" should "3" in {
        val ti = new NumberOfIslands()
        ti.numIslands(Array(
            Array('1','1','0','0','0'),
            Array('1','1','0','0','0'),
            Array('0','0','1','0','0'),
            Array('0','0','0','1','1')
        )) should be (3)
    }
}
