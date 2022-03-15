package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PopulatingNextRightPointersEachNodeSpec extends AnyFlatSpec with Matchers {

    "PopulatingNextRightPointersEachNode" should "scenario #1" in {
        val ti = new PopulatingNextRightPointersEachNode()
        val root = new Node(1,
            new Node(2, new Node(4), new Node(5)),
            new Node(3, new Node(6), new Node(7)))
        ti.connect(root)
        root.next should be (null)
        root.left.next should be (root.right)
        root.right.next should be (null)
    }

    "PopulatingNextRightPointersEachNode" should "scenario #2" in {
        val ti = new PopulatingNextRightPointersEachNode()
        ti.connect(null)
    }
}
