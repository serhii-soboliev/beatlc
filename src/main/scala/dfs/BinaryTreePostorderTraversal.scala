package org.sbk.leet
package dfs

import utils.TreeNode

/*
 145. Binary Tree Postorder Traversal
 https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
class BinaryTreePostorderTraversal {

    def postorderTraversal(root: TreeNode): List[Int] = {
        Option(root).map(tnn => {postorderTraversal(tnn.left) ::: postorderTraversal(tnn.right) ::: List(tnn.value)})
          .orElse(Option(List[Int]())).get
    }

}
