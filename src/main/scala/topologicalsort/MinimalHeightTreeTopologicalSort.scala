package org.sbk.leet
package topologicalsort

import scala.collection.mutable
import scala.collection.mutable._

/*
310. Minimum Height Trees
https://leetcode.com/problems/minimum-height-trees/
 */
class MinimalHeightTreeTopologicalSort {

    def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {

        if (n == 1)
            return List(0)

        val graph = mutable.Map[Int, ListBuffer[Int]]()
        val ans = ListBuffer[Int]()

        for {node <- edges} {
            val tmp1 = graph.getOrElse(node(0), ListBuffer[Int]())
            tmp1 += node(1)
            val tmp2 = graph.getOrElse(node(1), ListBuffer[Int]())
            tmp2 += node(0)
            graph += (node(0) -> tmp1)
            graph += (node(1) -> tmp2)
        }

        val leaves = graph
          .filter(_._2.length == 1)
          .keys
          .toList

        val noOfNodes = n
        val res = graph.foldLeft((noOfNodes, leaves))((tmpRes, _) => {
            tmpRes._1 match {
                case n if n <= 2 => (tmpRes._1, tmpRes._2)
                case _ =>
                    val newLeaves = ListBuffer[Int]()

                    for (leaf <- tmpRes._2) {
                        val parentNode = graph(leaf).head
                        graph(parentNode).subtractOne(leaf)
                        if (graph(parentNode).length == 1)
                            newLeaves += parentNode
                    }
                    (tmpRes._1 - tmpRes._2.length, newLeaves.toList)
            }
        })

        res._2
    }


}

object MinimalHeightTreeTopologicalSort {
    def main(args: Array[String]): Unit = {
        val o = new MinimalHeightTreeTopologicalSort
        //print(o.findMinHeightTrees(3, Array(Array(0,1), Array(0,2))))
        print(o.findMinHeightTrees(6, Array(Array(3, 0), Array(3, 1), Array(3, 2), Array(3, 4), Array(5, 4))))
        // print(o.findMinHeightTrees(4, Array(Array(1, 0), Array(1, 2), Array(1,3))))
    }
}

