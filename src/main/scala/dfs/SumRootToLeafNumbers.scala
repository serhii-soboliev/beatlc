package org.sbk.leet
package dfs

import utils.TreeNode


/*
129. Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
class SumRootToLeafNumbers {

    def sumNumbersNaive(root: TreeNode): Int = {
        if(root == null) return 0
        def dfs(v: String, n: TreeNode): Int = {
            if (n.left == null && n.right == null) return (v + n.value).toInt
            var res = 0
            if(n.left != null) res += dfs(v + n.value, n.left)
            if(n.right != null) res += dfs(v + n.value, n.right)
            res
        }
        dfs("", root)
    }

    def sumNumbers(root: TreeNode): Int = {
        import scala.util.control.TailCalls.{TailRec, done}
        def dfs(base: Int, n: TreeNode): TailRec[Int] = n match {
            case null => done(0)
            case n if n.right == null && n.left == null => done(base*10 + n.value)
            case _ =>
                val newBase = base * 10 + n.value
                for {
                    left <- dfs(newBase, n.left)
                    right <- dfs(newBase, n.right)
                } yield left + right
        }
        dfs(0, root).result
    }
}

