package org.sbk.leet
package dfs

import utils.TreeNode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LongestUnivaluePathSpec extends AnyFlatSpec with Matchers {

    "LongestUnivaluePathSpec [1,1]" should "1" in {
        val ti = new LongestUnivaluePath()
        val tn = new TreeNode(1, new TreeNode(1))
        ti.longestUnivaluePath(tn) should equal (1)
    }

    "LongestUnivaluePathSpec [5,4,5,1,1,5]" should "2" in {
        val ti = new LongestUnivaluePath()
        val tn = new TreeNode(5,
            new TreeNode(4, new TreeNode(1), new TreeNode(1)),
            new TreeNode(5, new TreeNode(5)))
        ti.longestUnivaluePath(tn) should equal (2)
    }

    "LongestUnivaluePathSpec [1,4,5,4,4,5]" should "2" in {
        val ti = new LongestUnivaluePath()
        val tn = new TreeNode(1,
            new TreeNode(4, new TreeNode(4), new TreeNode(4)),
            new TreeNode(5, new TreeNode(5)))
        ti.longestUnivaluePath(tn) should equal (2)
    }
}
