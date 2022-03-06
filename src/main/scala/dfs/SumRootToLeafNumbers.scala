package org.sbk.leet
package dfs

/*
129. Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
class SumRootToLeafNumbers {

    def sumNumbers(root: TreeNode): Int = {
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
}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}