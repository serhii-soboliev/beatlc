package org.sbk.leet
package bfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class AllPathsFromSourceToTargetSpec extends AnyFlatSpec with Matchers {

    "AllPathsFromSourceToTarget" should "scenario #1" in {
        val ti = new AllPathsFromSourceToTarget()
        ti.allPathsSourceTarget(Array(
            Array(1,2),
            Array(3),
            Array(3),
            Array()
        )) should be (List(List(0,1,3),List(0,2,3)))
    }

    "AllPathsFromSourceToTarget" should "scenario #2" in {
        val ti = new AllPathsFromSourceToTarget()
        ti.allPathsSourceTarget(Array(
            Array(4,3,1),
            Array(3,2,4),
            Array(3),
            Array(4),
            Array()
        )) should be (List(List(0,4),List(0,3,4),List(0,1,3,4), List(0,1,2,3,4),List(0,1,4)))
    }
}
