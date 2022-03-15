package org.sbk.leet
package bfs

/*
116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

class PopulatingNextRightPointersEachNode {
    def connect(root: Node): Node = {
        Option(root).map(r => {
            import scala.collection.mutable
            val q = new mutable.Queue[Node]()
            q += r
            val new_q = new mutable.Queue[Node]()
            do {
                new_q.removeAll()
                var t = q.dequeue()
                if (t.left != null) {
                    new_q += t.left
                    new_q += t.right
                }
                while (q.nonEmpty) {
                    val k = q.dequeue()
                    if (k.left != null) {
                        new_q += k.left
                        new_q += k.right
                    }
                    t.next = k
                    t = k
                }
                q.removeAll()
                q.addAll(new_q)
            } while (new_q.nonEmpty)
        })
        root
    }
}

class Node(var value: Int, var left: Node, var right: Node, var next: Node)  {

    def this(_value: Int) {
        this(_value, null, null, null)
    }

    def this(_value: Int, _left: Node, _right: Node) {
        this(_value, _left, _right, null)
    }

}