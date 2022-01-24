package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SubsetsSpec extends AnyFlatSpec with Matchers{

    "Subsets.subsets(Array(1,2,3))" should "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]" in {
        new Subsets().subsets(Array(1, 2, 3)) should contain allOf (
          List(), List(1), List(2), List(3),
          List(2, 1), List(3, 1), List(3, 2),
          List(3, 2, 1)
        )
    }

    "Subsets.subsets(Array(0))" should "[[],[0]]" in {
        new Subsets().subsets(Array(0)) should contain allOf (List(), List(0))
    }

    "Subsets.subsetsBitManipulation(Array(1,2,3))" should "[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]" in {
        new Subsets().subsetsBitManipulation(Array(1, 2, 3)) should contain allOf (
            List(), List(1), List(2), List(3),
            List(1, 2), List(1, 3), List(2, 3),
            List(1, 2, 3)
        )
    }

    "Subsets.subsetsBitManipulation(Array(0))" should "[[],[0]]" in {
        new Subsets().subsetsBitManipulation(Array(0)) should contain allOf (List(), List(0))
    }
}
