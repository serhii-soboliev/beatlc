package org.sbk.leet
package dfs

import utils.TreeNode

/*
104. Maximum Depth of Binary Tree
https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class MaximumDepthBinaryTree {
    def maxDepth(root: TreeNode): Int = Option(root)
      .map(r => {1 + (maxDepth(r.right) max maxDepth(r.left) )})
      .orElse(Option(0)).get
}
