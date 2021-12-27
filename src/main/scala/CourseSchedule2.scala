package org.sbk.leet

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CourseSchedule2 {

  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val prepequisitesMap = buildPrerequisitesMap(numCourses, prerequisites)
    val white:mutable.Buffer[Int] = (0 until numCourses).toBuffer
    val gray:mutable.Buffer[Int] = ArrayBuffer()
    val black:mutable.Buffer[Int] = ArrayBuffer()
    try {
      for (i <- 0 until numCourses) {
        tarianStep(i, white, gray, black, prepequisitesMap)
      }
    } catch {
      case _: IllegalArgumentException => return Array.empty[Int]
    }
    black.toArray.reverse
  }

  def tarianStep(p: Int, white: mutable.Buffer[Int], gray: mutable.Buffer[Int], black: mutable.Buffer[Int], prerequsitesMap:Array[Array[Int]]): Unit = {
    if (black.contains(p)) {
    } else if (gray.contains(p)) {
      throw new IllegalArgumentException("Cycle Found")
    } else {
      gray += p
      for (pr <- prerequsitesMap(p)) {
        tarianStep(pr, white, gray, black, prerequsitesMap)
      }
      black += p
    }
  }

  def buildPrerequisitesMap(numCourses:Int, prerequisites: Array[Array[Int]]) : Array[Array[Int]] = {
    val prepequisitesMap: Array[Array[Int]] = Array.fill[Array[Int]](numCourses)(Array.empty[Int])
    prerequisites foreach {
      p => {
        prepequisitesMap(p(1)) = prepequisitesMap(p(1)) :+ p(0)
      }
    }
    prepequisitesMap
  }
}

object CourseSchedule2 {
  def main(args: Array[String]): Unit = {
    val obj = new CourseSchedule2
    val res = obj.findOrder(4, Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2)))
    res foreach println
  }
}