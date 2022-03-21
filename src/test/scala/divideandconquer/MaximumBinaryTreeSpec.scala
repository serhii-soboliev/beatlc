package org.sbk.leet
package divideandconquer


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MaximumBinaryTreeSpec extends AnyFlatSpec with Matchers {

    "MaximumBinaryTree" should "scenario #1" in {
        val ti = new MaximumBinaryTree()
        val res = ti.constructMaximumBinaryTree(Array(3,2,1,6,0,5))
        res.value should be (6)
        res.left.value should be (3)
        res.right.value should be (5)
        res.left.left should be (null)
        res.left.right.value should be (2)
    }
}
