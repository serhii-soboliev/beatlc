package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec


class CourseSchedulerSpec extends AnyFlatSpec {

  "A CourseScheduler" should "return true" in {
    val testInstance = new CourseSchedule
    val res = testInstance.canFinish(
      2,
      Array(Array(1, 0))
    )
    assert(res)
  }

  "A CourseScheduler2" should "return false" in {
    val testInstance = new CourseSchedule
    val res = testInstance.canFinish(
      2,
      Array(Array(1, 0), Array(0,1))
    )
    assert(!res)
  }

  "A CourseScheduler 2" should "return true" in {
    val testInstance = new CourseSchedule
    val res = testInstance.canFinish(
      4,
      Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2))
    )
    assert(res)
  }
}



