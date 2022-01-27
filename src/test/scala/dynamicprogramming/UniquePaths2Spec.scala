package org.sbk.leet
package dynamicprogramming

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class UniquePaths2Spec extends AnyFlatSpec with Matchers{

    "UniquePaths2.uniquePathsII(Array(Array(0,0,0),Array(0,1,0),Array(0,0,0)))" should "equal 2" in {
        new UniquePaths2().uniquePathsWithObstacles(Array(Array(0,0,0),Array(0,1,0),Array(0,0,0))) should equal (2)
    }

    "UniquePaths2.uniquePathsII(Array(Array(0,0))" should "equal 1" in {
        new UniquePaths2().uniquePathsWithObstacles(Array(Array(0,0))) should equal (1)
    }

    "UniquePaths2.uniquePathsII(Array(Array(0,1),Array(0,0)))" should "equal 1" in {
        new UniquePaths2().uniquePathsWithObstacles(Array(Array(0,1),Array(0,0))) should equal (1)
    }

    "UniquePaths2.uniquePathsII(Array(Array(0,),Array(0,1)))" should "equal 0" in {
        new UniquePaths2().uniquePathsWithObstacles(Array(Array(0,0),Array(0,1))) should equal (0)
    }


    "UniquePaths2.uniquePathsIIDFS(Array(Array(0,0,0),Array(0,1,0),Array(0,0,0)))" should "equal 2" in {
        new UniquePaths2().uniquePathsWithObstaclesDFS(Array(Array(0,0,0),Array(0,1,0),Array(0,0,0))) should equal (2)
    }

    "UniquePaths2.uniquePathsIIDFS(Array(Array(0,1),Array(0,0)))" should "equal 2" in {
        new UniquePaths2().uniquePathsWithObstaclesDFS(Array(Array(0,1),Array(0,0))) should equal (1)
    }

    "UniquePaths2.uniquePathsIIDFS(Array(Array(0,),Array(0,1)))" should "equal 0" in {
        new UniquePaths2().uniquePathsWithObstaclesDFS(Array(Array(0,0),Array(0,1))) should equal (0)
    }

}
