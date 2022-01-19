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
    val map: mutable.Map[Int, ArrayBuffer[Int]] = mutable.Map[Int, ArrayBuffer[Int]]()

    def buildGraph(): Array[mutable.Set[Int]] = {
      val g = Array.fill[mutable.Set[Int]](n)(mutable.Set.empty[Int])
      prerequisites foreach(p => g(p(0)) += p(1))
      g
    }

    val graph = buildGraph()

    def dfs(i: Int, visited: Array[Boolean], path: ArrayBuffer[Int]) : ArrayBuffer[Int] = {
      visited(i) = true
      for(c <- graph(i)) {
        if(!visited(c)) {
          dfs(c, visited, path)
        }
      }
      path += i
      path
    }

    def buildMap() : Unit = {
      for(i <- 0 until numCourses) {
        map(i) = dfs(i, Array.fill[Boolean](numCourses)(false), ArrayBuffer[Int]())
      }
    }

    def buildAnswer(): Unit = {
      queries foreach(q => {
        ans += map(q(0)).contains(q(1))
      })
    }

    buildMap()
    buildAnswer()
    ans.toList
  }

}
