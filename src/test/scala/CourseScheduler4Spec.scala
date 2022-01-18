package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec


class CourseScheduler4Spec extends AnyFlatSpec {

  "A CourseScheduler4" should "return [false, true]" in {
    val testInstance = new CourseSchedule4
    val res = testInstance.checkIfPrerequisite(
      2,
      Array(Array(1, 0)),
      Array(Array(0, 1), Array(1, 0))
    )
    assert(res == List(false, true))
  }

  "A CourseScheduler4" should "return [false, false] " in {
    val testInstance = new CourseSchedule4
    val res = testInstance.checkIfPrerequisite(
      2,
      Array(),
      Array(Array(1,0), Array(0,1))
    )
    assert(res == List(false, false))
  }

}



