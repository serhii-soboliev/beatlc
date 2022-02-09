package org.sbk.leet
package slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MedianHeapSpec extends AnyFlatSpec with Matchers {

    "MedianHeapS.remove(5)" should "[6]" in {
        val mh = new MedianHeap()
        mh.insert(2)
        mh.insert(3)
        mh.insert(4)
        mh.remove(3)

    }

    "Median from (1, 2, 3, 4, 5)" should "3" in {
        val mh = new MedianHeap(Array(1, 2, 3, 4, 5))
        mh.findMedian() should equal(3)
    }

    "Median from (1, 2, 3, 4, 5, 6)" should "3.5" in {
        val mh = new MedianHeap(Array(1, 2, 3, 4, 5, 6))
        mh.findMedian() should equal(3.5)
    }


}
