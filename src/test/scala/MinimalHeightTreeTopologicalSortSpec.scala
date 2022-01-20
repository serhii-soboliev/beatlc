package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec


class MinimalHeightTreeTopologicalSortSpec extends AnyFlatSpec {

    "MinimalHeightTreeTopologicalSort" should "return [0]" in {
        val testInstance = new MinimalHeightTreeTopologicalSort
        assert(testInstance.findMinHeightTrees(3, Array(Array(0, 1), Array(0, 2))) == List(0))
    }

    "MinimalHeightTreeTopologicalSort" should "return [3,4]" in {
        val testInstance = new MinimalHeightTreeTopologicalSort
        assert(testInstance.findMinHeightTrees(6, Array(Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(5, 4))) == List(3, 4))
    }

    "MinimalHeightTreeTopologicalSort" should "return [1]" in {
        val testInstance = new MinimalHeightTreeTopologicalSort
        assert(testInstance.findMinHeightTrees(4, Array(Array(1, 0), Array(1, 2), Array(1, 3))) == List(1))
    }


}



