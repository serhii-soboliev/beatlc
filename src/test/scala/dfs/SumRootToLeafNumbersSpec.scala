package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SumRootToLeafNumbersSpec extends AnyFlatSpec with Matchers {

    "SumRootToLeafNumbers" should "1026" in {
        val t = new SumRootToLeafNumbers()
        t.sumNumbers(new TreeNode(
            4,
            new TreeNode(9, new TreeNode(5), new TreeNode(1)),
            new TreeNode(0))
        ) should be (1026)
    }

    "SumRootToLeafNumbers" should "25" in {
        val t = new SumRootToLeafNumbers()
        t.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))) should be (25)
    }
}
