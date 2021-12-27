package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec


class CourseScheduler2Spec extends AnyFlatSpec {

  "A CourseScheduler2" should "return [0,1]" in {
    val testInstance = new CourseSchedule2
    val res = testInstance.findOrder(
      2,
      Array(Array(1, 0))
    )
    assert(res === Array(0,1))
  }

  "A CourseScheduler2" should "return empty array" in {
    val testInstance = new CourseSchedule2
    val res = testInstance.findOrder(
      2,
      Array(Array(1, 0), Array(0,1))
    )
    assert(res === Array.empty)
  }
}



