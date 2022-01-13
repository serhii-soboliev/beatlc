package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec

class EventualSafeStateSpec extends AnyFlatSpec {

    "A EventualSafeStateSpec" should "return List(2, 4, 5, 6)" in {
      val testInstance = new EventualSafeStates
      val res = testInstance.eventualSafeNodes(Array(Array(1, 2), Array(2, 3), Array(5), Array(0), Array(5), Array(), Array()))
      assert(res == List(2, 4, 5, 6))
    }
}
