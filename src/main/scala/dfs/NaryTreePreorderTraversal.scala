package org.sbk.leet
package dfs

import utils.Node

/*
589. N-ary Tree Preorder Traversal
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
class NaryTreePreorderTraversal {
    def preorder(root: Node): List[Int] = {
        Option(root).map(tnn => List(tnn.value) ::: root.children.flatMap(cn => preorder(cn))).getOrElse(List())
    }
}
