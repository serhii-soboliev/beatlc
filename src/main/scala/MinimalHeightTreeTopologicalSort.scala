package org.sbk.leet

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class MinimalHeightTreeTopologicalSort {

  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
    val edgesMap = buildEdgesMap(n,edges)
    var leaves = findLeaves(edgesMap)
    var vertexesLeft = n
    while (vertexesLeft > 2) {
      vertexesLeft -= leaves.size
      leaves = removeLeaves(leaves, edgesMap)
    }
    leaves.toList
  }

  private def removeLeaves(leaves: mutable.Set[Int], edgesMap: mutable.Map[Int, ArrayBuffer[Int]]): mutable.Set[Int] = {
    val newLeaves = mutable.Set[Int]()
    for(leaf <- leaves) {
      for(v <- edgesMap(leaf)) {
        edgesMap(v) -= leaf
        if(edgesMap(v).length <= 1) {
          newLeaves += v
        }
      }
      edgesMap.remove(leaf)
    }
    newLeaves
  }

  private def findLeaves(edgesMap: mutable.Map[Int, ArrayBuffer[Int]]) : mutable.Set[Int] = {
    edgesMap
      .filter(v => v._2.length <= 1)
      .keySet
      .to(collection.mutable.Set)
  }

  private def buildEdgesMap(n: Int, edges: Array[Array[Int]]): mutable.Map[Int, ArrayBuffer[Int]] = {
    val r = mutable.Map[Int, ArrayBuffer[Int]]()
    for (i <- 0 until n) {
      r(i) = ArrayBuffer[Int]()
    }
    for(e <- edges) {
      val v1 = e(0)
      val v2 = e(1)
      r(v1) += v2
      r(v2) += v1
    }
    r
  }

}

object MinimalHeightTreeTopologicalSort {
  def main(args: Array[String]): Unit = {
    val o = new MinimalHeightTreeTopologicalSort
    //print(o.findMinHeightTrees(3, Array(Array(0,1), Array(0,2))))
     print(o.findMinHeightTrees(6, Array(Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(5,4))))
    // print(o.findMinHeightTrees(4, Array(Array(1, 0), Array(1, 2), Array(1,3))))
  }
}

