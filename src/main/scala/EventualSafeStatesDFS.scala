package org.sbk.leet

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

/*
802. Find Eventual Safe States
https://leetcode.com/problems/find-eventual-safe-states/
 */
class EventualSafeStatesDFS {

  def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
    val n = graph.length
    val ans = ListBuffer[Int]()
    //WHITE=0, GREY=1, BLACK=2
    val color = Array.fill[Int](n)(0)

    def dfs(node: Int, color: Array[Int]): Boolean = {
      if(color(node) != 0){
        color(node) != 1
      }

      color(node) = 1
      for(nei <- graph(node)) {
        breakable {
          if (color(nei) == 2) break
          if (color(nei) == 1 || !dfs(nei, color)) {
            return false
          }
        }
      }
      color(node) = 2
      true
    }

    for(i <- 0 until n) {
      if(dfs(i, color)) {
        ans += i
      }
    }
    ans.toList
  }
}


