package org.sbk.leet
package dfs


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import utils.TreeNode

class BinaryTreeMaximumPathSumSpec extends AnyFlatSpec with Matchers {

    "BinaryTreeMaximumPathSum [1,2,3]" should "6" in {
        val ti = new BinaryTreeMaximumPathSum()
        ti.maxPathSumNaive(new TreeNode(1, new TreeNode(2), new TreeNode(3))) should be (6)
    }

    "BinaryTreeMaximumPathSum [9,-10,20,15,7]" should "42" in {
        val ti = new BinaryTreeMaximumPathSum()
        ti.maxPathSumNaive(new TreeNode(-10,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7)))) should be (42)
    }

    "BinaryTreeMaximumPathSum [5,4,8,11,null,13,4, 7,2,null,null,null,1]" should "49" in {
        val ti = new BinaryTreeMaximumPathSum()
        ti.maxPathSumNaive(new TreeNode(5,
            new TreeNode(4,
                new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                null),
            new TreeNode(8,
                new TreeNode(13, null, new TreeNode(1)),
                new TreeNode(4)))) should be (49)
    }

    "BinaryTreeMaximumPathSumRec [9,-10,20,15,7]" should "42" in {
        val ti = new BinaryTreeMaximumPathSum()
        ti.maxPathSum(new TreeNode(-10,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7)))) should be (42)
    }

    "BinaryTreeMaximumPathSumRec [5,4,8,11,null,13,4, 7,2,null,null,null,1]" should "49" in {
        val ti = new BinaryTreeMaximumPathSum()
        ti.maxPathSum(new TreeNode(5,
            new TreeNode(4,
                new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                null),
            new TreeNode(8,
                new TreeNode(13, null, new TreeNode(1)),
                new TreeNode(4)))) should be (49)
    }




}
