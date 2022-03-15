package org.sbk.leet
package bfs

/*
117. Populating Next Right Pointers in Each Node II
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

class PopulatingNextRightPointersEachNode2 {

    def connect(root: Node): Node = {
        Option(root).map(r => {
            import scala.collection.mutable
            val q = mutable.Queue(r)
            val new_q = new mutable.Queue[Node]()
            do {
                new_q.removeAll()
                var t = q.dequeue()
                Option(t.left).map(_ => new_q += t.left)
                Option(t.right).map(_ => new_q += t.right)
                while (q.nonEmpty) {
                    val k = q.dequeue()
                    Option(k.left).map(_ => new_q += k.left)
                    Option(k.right).map(_ => new_q += k.right)
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
