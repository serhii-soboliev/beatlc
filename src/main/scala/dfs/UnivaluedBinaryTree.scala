package org.sbk.leet
package dfs

import utils.TreeNode

/*
965. Univalued Binary Tree
https://leetcode.com/problems/univalued-binary-tree/
 */
class UnivaluedBinaryTree {

    def isUnivalTree(root: TreeNode): Boolean = {
        def dfs(tn: TreeNode): Boolean = Option(tn).forall(tnn => tnn.value == root.value && dfs(tn.left) && dfs(tn.right))
        dfs(root)
    }
}
