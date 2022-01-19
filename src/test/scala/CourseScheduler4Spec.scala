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

  "A CourseScheduler4" should "return [true, true] " in {
    val testInstance = new CourseSchedule4
    val res = testInstance.checkIfPrerequisite(
      3,
      Array(Array(1,2), Array(1,0), Array(2,0)),
      Array(Array(1,0), Array(1,2))
    )
    assert(res == List(true, true))
  }

  "A CourseScheduler4" should "return [true, true, true] " in {
    val testInstance = new CourseSchedule4
    val res = testInstance.checkIfPrerequisite(
      4,
      Array(Array(2,3), Array(2,1), Array(0,3), Array(0,1)),
      Array(Array(0,1), Array(0,3), Array(2,3), Array(3,0), Array(2,0), Array(0,2))
    )
    assert(res == List(true, true, true, false, false, false))
  }
}



