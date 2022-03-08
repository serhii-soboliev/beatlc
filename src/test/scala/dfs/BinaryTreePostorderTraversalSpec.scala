package org.sbk.leet
package dfs

import utils.TreeNode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class BinaryTreePostorderTraversalSpec extends AnyFlatSpec with Matchers {

    "[1,null,2,3]" should "[3,2,1]" in {
        val nt = new BinaryTreePostorderTraversal()
        val nd = new TreeNode(1, null, new TreeNode(2, new TreeNode(3)))
        nt.postorderTraversal(nd) should equal (List(3,2,1))
    }
}
