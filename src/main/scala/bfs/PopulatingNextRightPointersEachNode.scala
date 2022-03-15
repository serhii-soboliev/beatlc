package org.sbk.leet
package bfs

/*
116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

class PopulatingNextRightPointersEachNode {

    def connect(root: Node): Node = root match {
        case null => null
        case _ =>
            Option(root.left).map(_ => {
                root.left.next = root.right
                Option(root.next).map(_ => root.right.next = root.next.left)
            })
            connect(root.left)
            connect(root.right)
            root
    }

    def connectNaive(root: Node): Node = {
        Option(root).map(r => {
            import scala.collection.mutable
            val q = mutable.Queue(r)
            val new_q = new mutable.Queue[Node]()
            do {
                new_q.removeAll()
                var t = q.dequeue()
                Option(t.left).map(_ => new_q.addAll(Array(t.left, t.right)))
                while (q.nonEmpty) {
                    val k = q.dequeue()
                    Option(k.left).map(_ => new_q.addAll(Array(k.left, k.right)))
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