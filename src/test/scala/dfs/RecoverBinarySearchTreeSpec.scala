package org.sbk.leet
package dfs

import utils.TreeNode
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RecoverBinarySearchTreeSpec extends AnyFlatSpec with Matchers {

    "[1,3,null,null,2]" should "[3,1,null,null,2]" in {
        val t = new RecoverBinarySearchTree()
        val root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)))
        t.recoverTree(root)
        root.value should be (3)
        root.left.value should be (1)
    }

    " [3,1,4,null,null,2]" should "[2,1,4,null,null,3]" in {
        val t = new RecoverBinarySearchTree()
        val root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2)))
        t.recoverTree(root)
        root.value should be (2)
        root.right.left.value should be (3)
    }

}
