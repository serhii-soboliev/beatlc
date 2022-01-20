package org.sbk.leet

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class CourseSchedule {
    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
        val m = buildPrerequisitesMap(prerequisites, numCourses)
        val white: mutable.Buffer[Int] = (0 until numCourses).toBuffer
        val gray: mutable.Buffer[Int] = ArrayBuffer()
        val black: mutable.Buffer[Int] = ArrayBuffer()
        try {
            for (i <- 0 until numCourses) {
                tarianStep(i, white, gray, black, m)
            }
            true
        } catch {
            case _: IllegalArgumentException => false
        }
    }

    def tarianStep(p: Int, white: mutable.Buffer[Int], gray: mutable.Buffer[Int], black: mutable.Buffer[Int], m: Array[Array[Int]]): Unit = {
        if (black.contains(p)) {
        } else if (gray.contains(p)) {
            throw new IllegalArgumentException("Cycle Found")
        } else {
            gray += p
            for (pr <- m(p)) {
                tarianStep(pr, white, gray, black, m)
            }
            black += p
        }
    }

    def buildPrerequisitesMap(p: Array[Array[Int]], n: Int): Array[Array[Int]] = {
        val m: Array[Array[Int]] = Array.fill[Array[Int]](n)(Array.empty[Int])
        p.groupBy(_.head)
          .map { case (k, v) => k -> v.flatMap(_.tail) }
          .foreach { case (k, v) => m(k) = v }
        m
    }

}

object CourseSchedule {
    def main(args: Array[String]): Unit = {
        val c = new CourseSchedule
        print(c.canFinish(4, Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2))))
    }
}
