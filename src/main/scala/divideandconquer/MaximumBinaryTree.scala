package org.sbk.leet
package divideandconquer

import utils.TreeNode

/*
654. Maximum Binary Tree
https://leetcode.com/problems/maximum-binary-tree/
 */
class MaximumBinaryTree {
    def constructMaximumBinaryTree(a: Array[Int]): TreeNode = {
        if (a.isEmpty) return null
        val i = a.indices.maxBy(a)
        new TreeNode(a(i), constructMaximumBinaryTree(a.slice(0, i)), constructMaximumBinaryTree(a.slice(i + 1, a.length)))
    }
}
