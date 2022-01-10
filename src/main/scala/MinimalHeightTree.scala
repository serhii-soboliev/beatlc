package org.sbk.leet

import scala.collection.mutable.ArrayBuffer

/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/
 */
class MinimalHeightTree {
    def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
        val d = findDiameter(n, edges)
        if(d.length % 2 == 0)
             List(d(d.length / 2 - 1), d(d.length / 2 ))
        else List(d(d.length / 2))

    }

    def findDiameter(n: Int, edges: Array[Array[Int]]) : Array[Int] = {
        val firstLongestPath = findLongestPathFromVertex(n, 0, edges)
        val diameter = findLongestPathFromVertex(n, firstLongestPath.last, edges)
        diameter
    }

    def findLongestPathFromVertex(n: Int, firstVertex:Int, edges: Array[Array[Int]]): Array[Int] = {
        val paths = ArrayBuffer(ArrayBuffer(firstVertex))
        findAllPaths(paths, buildEdgesMap(n, edges)).sortBy(_.length)(Ordering[Int].reverse).last.toArray
    }

    def findAllPaths(paths: ArrayBuffer[ArrayBuffer[Int]], edgesMap: Array[ArrayBuffer[Int]]) : ArrayBuffer[ArrayBuffer[Int]] ={
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
            findAllPaths(paths, edgesMap)
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
        print(o.findMinHeightTrees(3, Array(Array(0,1), Array(0,2))))
       // print(o.findMinHeightTrees(6, Array(Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(5,4))))
       // print(o.findMinHeightTrees(4, Array(Array(1, 0), Array(1, 2), Array(1,3))))
    }
}
