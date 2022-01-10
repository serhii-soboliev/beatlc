package org.sbk.leet

import scala.collection.mutable.ArrayBuffer

/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/
 */
class MinimalHeightTree {
    def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
        val edgesMap = buildEdgesMap(n, edges)
        findDiameter(edgesMap)
        null
    }

    def findDiameter(edgesMap: Array[ArrayBuffer[Int]]) : Int = {
        val firstVertex = 0
        val paths = ArrayBuffer(ArrayBuffer(firstVertex))
        val allPaths = findAllPathsFromVertex(paths, edgesMap)
        0
    }

    def findAllPathsFromVertex(paths: ArrayBuffer[ArrayBuffer[Int]], edgesMap: Array[ArrayBuffer[Int]]) : ArrayBuffer[ArrayBuffer[Int]] ={
        val newPaths:ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer()
        for(path <- paths) {
            val accessibleVertexes = edgesMap(path.last)
            for (av <- accessibleVertexes) {
                if (!path.contains(av)) {
                    val newPath = path.clone()
                    newPath += av
                    newPaths += newPath
                }
            }
        }
        if(newPaths.nonEmpty) {
            paths.clear()
            paths.addAll(newPaths)
            findAllPathsFromVertex(paths, edgesMap)
        }
        paths
    }


    private def buildEdgesMap(n: Int, edges: Array[Array[Int]]): Array[ArrayBuffer[Int]] = {
        val r = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
        for(e <- edges) {
            val v1 = e(0)
            val v2 = e(1)
            r(v1) += v2
            r(v2) += v1
        }
        r
    }
}

object MinimalHeightTree {
    def main(args: Array[String]): Unit = {
        val o = new MinimalHeightTree
       // o.findMinHeightTrees(4, Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2), Array(2,1)))
        o.findMinHeightTrees(4, Array(Array(1, 0), Array(1, 2), Array(3, 1)))
    }
}
