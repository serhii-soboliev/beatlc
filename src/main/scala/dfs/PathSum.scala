package org.sbk.leet
package dfs

import utils.TreeNode



/*
112. Path Sum
https://leetcode.com/problems/path-sum/
 */
class PathSum {

    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        import scala.util.control.TailCalls.{TailRec, done}

        def isLeaf(nod: TreeNode): Boolean = {
            nod.left == null && nod.right == null
        }

        def dfs(n: TreeNode, sum: Int): TailRec[Boolean] = n match {
            case null => done(false)
            case n if isLeaf(n) && sum + n.value == targetSum => done(true)
            case _ =>
                val newSum = sum + n.value
                for {
                    l <- dfs(n.left, newSum)
                    r <- dfs(n.right, newSum)
                } yield l || r

        }
        dfs(root, 0).result
    }

}



