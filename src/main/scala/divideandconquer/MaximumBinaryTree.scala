package org.sbk.leet
package divideandconquer

import utils.TreeNode

/*
654. Maximum Binary Tree
https://leetcode.com/problems/maximum-binary-tree/
 */
class MaximumBinaryTree {
    def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
        def dfs(a: Array[Int]): TreeNode = {
            if(a.isEmpty) return null
            if(a.length == 1) return new TreeNode(a(0))
            val i = a.indices.maxBy(a)
            val left = dfs(a.slice(0, i))
            val right = dfs(a.slice(i+1, a.length))
            new TreeNode(a(i), left, right)
        }
        dfs(nums)
    }
}
