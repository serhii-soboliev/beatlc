package org.sbk.leet

import scala.collection.mutable
import scala.collection.mutable._

/**
 * 1462. Course Schedule IV
 * https://leetcode.com/problems/course-schedule-iv/
 */
class CourseSchedule4 {

  def checkIfPrerequisite(numCourses: Int, prerequisites: Array[Array[Int]], queries: Array[Array[Int]]): List[Boolean] = {
    val n = numCourses
    val ans = new ListBuffer[Boolean]()

    def buildGraph(): Array[ArrayBuffer[Int]] = {
      val g = Array.fill[ArrayBuffer[Int]](n)(ArrayBuffer.empty[Int])
      prerequisites foreach(p => g(p(0)) += p(1))
      g
    }

    val graph = buildGraph()

    val memo = mutable.Set[(Int, Int)]()

    def dfs(a: Int, b: Int) : Boolean = {
      if(memo.contains((a,b))) {
        return true
      }
      val children = graph(a)
      if(a == b || children.contains(b)) {
        memo += Tuple2(a,b)
        return true
      }

      for(c <- graph(a)) {
       if(dfs(c,b)) {
         memo += Tuple2(a,b)
         memo += Tuple2(c,b)
         return true
       }
      }
      false
    }

    def buildAnswer(): Unit = {
      queries foreach(q => ans += dfs(q(0), q(1)))
    }

    buildAnswer()
    ans.toList
  }

}
