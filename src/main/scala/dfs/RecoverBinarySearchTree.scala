package org.sbk.leet
package dfs

/*
99. Recover Binary Search Tree
https://leetcode.com/problems/recover-binary-search-tree/
 */
class RecoverBinarySearchTree {

    import utils.TreeNode

    def recoverTree(n: TreeNode): Unit = {
        var prevNode, fstToSwap, sndToSwap: TreeNode = null

        def inorderTraverse(n: TreeNode): Unit = {
            if (n != null) {
                inorderTraverse(n.left)

                if (prevNode != null && prevNode.value > n.value && fstToSwap == null) fstToSwap = prevNode
                if (prevNode != null && prevNode.value > n.value && fstToSwap != null) sndToSwap = n

                prevNode = n

                inorderTraverse(n.right)
            }
        }

        inorderTraverse(n)

        val fstToSwapValue = fstToSwap.value
        fstToSwap.value = sndToSwap.value
        sndToSwap.value = fstToSwapValue
    }

}
