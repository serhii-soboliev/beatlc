package org.sbk.leet
package dfs

import utils.TreeNode

/*
687. Longest Univalue Path
https://leetcode.com/problems/longest-univalue-path/
 */
class LongestUnivaluePath {

    def longestUnivaluePath(root: TreeNode): Int = {
        var res = 0
        def dfs(n: TreeNode): Int = {
            if(n == null) return 0
            val leftPath = dfs(n.left)
            val rightPath = dfs(n.right)
            val leftCheck = if(n.left != null && n.left.value == n.value) leftPath + 1 else 0
            val rightCheck = if(n.right != null && n.right.value == n.value) rightPath + 1 else 0
            res = res max (leftCheck + rightCheck)
            leftCheck max rightCheck
        }
        dfs(root)
        res
    }
}


