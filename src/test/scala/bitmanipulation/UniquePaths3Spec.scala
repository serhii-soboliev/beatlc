package org.sbk.leet
package bitmanipulation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UniquePaths3Spec extends AnyFlatSpec with Matchers{

    "UniquePaths3.uniquePathsIII(Array(Array(1,0,0,0),Array(0,0,0,0),Array(0,0,2,-1)))" should "equal 2" in {
        new UniquePaths3().uniquePathsIII(Array(Array(1,0,0,0),Array(0,0,0,0),Array(0,0,2,-1))) should equal (2)
    }

    "UniquePaths3.uniquePathsIII(Array(Array(1,0,0,0),Array(0,0,0,0),Array(0,0,0,2)))" should "equal 4" in {
        new UniquePaths3().uniquePathsIII(Array(Array(1,0,0,0),Array(0,0,0,0),Array(0,0,0,2))) should equal (4)
    }

    "UniquePaths3.uniquePathsIII(Array(Array(0,1), Array(2,0))" should "equal 0" in {
        new UniquePaths3().uniquePathsIII(Array(Array(0,1), Array(2,0))) should equal (0)
    }


}
