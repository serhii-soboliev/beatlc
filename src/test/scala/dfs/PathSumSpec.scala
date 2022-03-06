package org.sbk.leet
package dfs

import utils.TreeNode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PathSumSpec extends AnyFlatSpec with Matchers {

    "PathSumSpec" should "false #1" in {
        val t = new PathSum()
        t.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5) should be (false)
    }

    "PathSumSpec" should "true #1" in {
        val t = new PathSum()
        t.hasPathSum(new TreeNode(
            5,
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2))),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))),
            22
        ) should be (true)
    }
}
