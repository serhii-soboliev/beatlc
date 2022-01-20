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
            Array(Array(1, 0), Array(0, 1))
        )
        assert(res == List(false, false))
    }

    "A CourseScheduler4" should "return [true, true] " in {
        val testInstance = new CourseSchedule4
        val res = testInstance.checkIfPrerequisite(
            3,
            Array(Array(1, 2), Array(1, 0), Array(2, 0)),
            Array(Array(1, 0), Array(1, 2))
        )
        assert(res == List(true, true))
    }

    "A CourseScheduler4" should "return [true, true, true] " in {
        val testInstance = new CourseSchedule4
        val res = testInstance.checkIfPrerequisite(
            4,
            Array(Array(2, 3), Array(2, 1), Array(0, 3), Array(0, 1)),
            Array(Array(0, 1), Array(0, 3), Array(2, 3), Array(3, 0), Array(2, 0), Array(0, 2))
        )
        assert(res == List(true, true, true, false, false, false))
    }

    "A CourseScheduler4" should "return [true, true, true] long" in {
        val testInstance = new CourseSchedule4
        val res = testInstance.checkIfPrerequisite(
            13,
            Array(Array(2, 1), Array(2, 7), Array(2, 0), Array(2, 10), Array(2, 11), Array(1, 7), Array(1, 0), Array(1, 9), Array(1, 4), Array(1, 11), Array(7, 3), Array(7, 9), Array(7, 4), Array(7, 11), Array(7, 8), Array(3, 6), Array(3, 12), Array(3, 5), Array(6, 10), Array(6, 8), Array(0, 4), Array(12, 9), Array(12, 8), Array(9, 4), Array(9, 11), Array(9, 8), Array(9, 5), Array(10, 8), Array(4, 8)),
            Array(Array(12, 11), Array(11, 1), Array(10, 12), Array(9, 10), Array(10, 11), Array(11, 12), Array(2, 7), Array(6, 8), Array(3, 2), Array(9, 5), Array(8, 7), Array(1, 4), Array(3, 12), Array(9, 6), Array(4, 3), Array(11, 4), Array(5, 7), Array(3, 9), Array(3, 1), Array(8, 12), Array(5, 12), Array(0, 8), Array(10, 5), Array(10, 11), Array(12, 11), Array(12, 9), Array(5, 4), Array(11, 5), Array(12, 10), Array(11, 0), Array(6, 10), Array(11, 7), Array(8, 10), Array(2, 1), Array(3, 4), Array(8, 7), Array(11, 6), Array(9, 11), Array(1, 4), Array(10, 8), Array(7, 1), Array(8, 7), Array(9, 7), Array(5, 1), Array(8, 10), Array(11, 8), Array(8, 12), Array(9, 12), Array(12, 11), Array(6, 12), Array(12, 11), Array(6, 10), Array(9, 12), Array(8, 10), Array(8, 11), Array(8, 5), Array(7, 9), Array(12, 11), Array(11, 12), Array(8, 0), Array(12, 11), Array(7, 0), Array(8, 7), Array(5, 11), Array(11, 8), Array(1, 9), Array(4, 10), Array(11, 6), Array(10, 12))
        )
        Array(3, 4)
        assert(res == List(true, false, false, false, false, false, true, true, false, true, false, true, true, false, false, false, false, true, false, false, false, true, false, false, true, true, false, false, false, false, true, false, false, true, true, false, false, true, true, true, false, false, false, false, false, false, false, false, true, false, true, true, false, false, false, false, true, true, false, false, true, false, false, false, false, true, false, false, false))
    }

    "A CourseScheduler4" should "return [true, true, true] long 2" in {
        val testInstance = new CourseSchedule4
        val res = testInstance.checkIfPrerequisite(
            13,
            Array(Array(2, 1), Array(2, 7), Array(2, 0), Array(2, 10), Array(2, 11), Array(1, 7), Array(1, 0), Array(1, 9), Array(1, 4), Array(1, 11), Array(7, 3), Array(7, 9), Array(7, 4), Array(7, 11), Array(7, 8), Array(3, 6), Array(3, 12), Array(3, 5), Array(6, 10), Array(6, 8), Array(0, 4), Array(12, 9), Array(12, 8), Array(9, 4), Array(9, 11), Array(9, 8), Array(9, 5), Array(10, 8), Array(4, 8)),
            Array(Array(3, 4))
        )
        assert(res == List(true))
    }


}



