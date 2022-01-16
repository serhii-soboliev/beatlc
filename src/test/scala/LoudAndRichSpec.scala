package org.sbk.leet

import org.scalatest.flatspec.AnyFlatSpec

class LoudAndRichSpec  extends AnyFlatSpec{

  "A loudAndRichTopologicalSort" should "return List(5,5,2,5,4,5,6,7)" in {
    val testInstance = new LoudAndRich
    val res = testInstance.loudAndRichTopologicalSort(
      Array(Array(1, 0), Array(2, 1), Array(3,1), Array(3,7), Array(4,3), Array(5,3), Array(6,3)),
      Array(3,2,5,4,6,1,7,0)
    )
    assert(res sameElements  Array(5, 5, 2, 5, 4, 5, 6, 7))
  }

  "A LoudAndRichBFS" should "return List(5,5,2,5,4,5,6,7)" in {
    val testInstance = new LoudAndRich
    val res = testInstance.loudAndRichBFS(
      Array(Array(1, 0), Array(2, 1), Array(3,1), Array(3,7), Array(4,3), Array(5,3), Array(6,3)),
      Array(3,2,5,4,6,1,7,0)
    )
    assert(res sameElements  Array(5, 5, 2, 5, 4, 5, 6, 7))
  }

}
