package org.sbk.leet
package dfs

import utils.TreeNode
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RangeSumOfBSTSpec extends AnyFlatSpec with Matchers {

    "RangeSumOfBST" should "32" in {
        val ti = new RangeSumOfBST()
        val tn = new TreeNode(10,
            new TreeNode(5, new TreeNode(3), new TreeNode(7)),
            new TreeNode(15, null, new TreeNode(18)))
        ti.rangeSumBST(tn, 7, 15) should be (32)
    }

    "RangeSumOfBST" should "23" in {
        val ti = new RangeSumOfBST()
        val tn = new TreeNode(10,
            new TreeNode(5, new TreeNode(3, new TreeNode(1)), new TreeNode(7, new TreeNode(6))),
            new TreeNode(15, new TreeNode(13), new TreeNode(18)))
        ti.rangeSumBST(tn, 6, 10) should be (23)
    }

}


