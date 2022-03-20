package org.sbk.leet
package dfs

import utils.TreeNode

/*
965. Univalued Binary Tree
https://leetcode.com/problems/univalued-binary-tree/
 */
class UnivaluedBinaryTree {

    def isUnivalTree(root: TreeNode): Boolean = {
        val n = root.value
        def dfs(tn: TreeNode): Boolean = {
            if(tn == null) return true
            (tn.value == n) && dfs(tn.left) && dfs(tn.right)
        }
        dfs(root)
    }
}
