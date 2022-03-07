package org.sbk.leet
package dfs


import utils.Node
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class NaryTreePostorderTraversalSpec extends AnyFlatSpec with Matchers {

    "[1,null,3,2,4,null,5,6]" should "[5,6,3,2,4,1]" in {
        val nt = new NaryTreePostorderTraversal()
        val nd = new Node(1)
        val c = new Node(3)
        c.children = List(new Node(5), new Node(6))
        nd.children = List(c, new Node(2), new Node(4))

        nt.postorder(nd) should be (List(5,6,3,2,4,1))
    }
}
