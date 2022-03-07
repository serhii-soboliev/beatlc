package org.sbk.leet
package dfs

import utils.Node

/*
590. N-ary Tree Postorder Traversal
https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
class NaryTreePostorderTraversal {

    def postorder(root: Node): List[Int] = {
        import scala.collection.mutable.ListBuffer
        val res = ListBuffer[Int]()

        def po(n:Node): Unit = {
            Option(n).map(v => {
                v.children.foreach(c => po(c))
                res += n.value
            })
        }

        po(root)
        res.toList
    }
}
