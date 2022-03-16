package org.sbk.leet
package dfs

import utils.TreeNode

/*
124. Binary Tree Maximum Path Sum
https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
class BinaryTreeMaximumPathSum {

    def maxPathSum(root: TreeNode): Int = {
        var res = Int.MinValue
        def dfs(tn: TreeNode): Int = {
            if(tn == null) return 0
            val leftMax = dfs(tn.left) max 0
            val rightMax = dfs(tn.right) max 0
            res = res max (tn.value + leftMax + rightMax)
            tn.value + (leftMax max rightMax)
        }
        dfs(root)
        res
    }

    def maxPathSumNaive(root: TreeNode): Int = {
        var res = Int.MinValue
        def dfs(tn: TreeNode): Int = {
            if(tn == null) return 0
            val leftMax = dfs(tn.left) max 0
            val rightMax = dfs(tn.right) max 0
            res = res max (tn.value + leftMax + rightMax)
            tn.value + (leftMax max rightMax)
        }
        dfs(root)
        res
    }

}
