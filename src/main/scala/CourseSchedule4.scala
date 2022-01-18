package org.sbk.leet

import scala.collection.mutable.{ListBuffer, ArrayBuffer}

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

    def buildAnswer(): Unit = {
      queries foreach(q => ans += dfs(q(0), q(1)))
    }

    def dfs(a: Int, b: Int) : Boolean = {
      for(c <- graph(a)) {
        if (c == b || dfs(c,b)) {
           return true
        }
      }
      false
    }

    buildAnswer()
    ans.toList
  }

}
