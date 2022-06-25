package org.sbk.leet.backtracking

/*
95. Unique Binary Search Trees II
https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class UniqueBinarySearchTreesll {

    fun generateTrees(n: Int): List<TreeNode?> {
        return generateTrees(1, n)
    }

    private fun generateTrees(start: Int, end: Int) : List<TreeNode?> {

        if(start > end) {
            return mutableListOf()
        }

        if(start == end) {
            return mutableListOf(TreeNode(start))
        }

        val accumulator = mutableListOf<TreeNode?>()
        (start..end).forEach { m ->
            val leftTrees = generateTrees(start, m-1)
            val rightTrees = generateTrees(m+1, end)

            if(leftTrees.isEmpty() && rightTrees.isEmpty()) {
                accumulator += TreeNode(m)
            } else if (leftTrees.isEmpty()) {
                for (rightTree in rightTrees) {
                    val newTree = TreeNode(m)
                    newTree.right = rightTree
                    accumulator += newTree
                }
            } else if (rightTrees.isEmpty()) {
                for(leftTree in leftTrees) {
                    val newTree = TreeNode(m)
                    newTree.left = leftTree
                    accumulator += newTree
                }
            } else {
                for (rightTree in rightTrees) {
                    for(leftTree in leftTrees) {
                        val newTree = TreeNode(m)
                        newTree.left = leftTree
                        newTree.right = rightTree
                        accumulator += newTree
                    }
                }
            }
        }
        return accumulator
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val u = UniqueBinarySearchTreesll().generateTrees(3)
            print(u)
        }
    }

}