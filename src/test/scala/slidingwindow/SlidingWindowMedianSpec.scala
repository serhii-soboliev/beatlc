package org.sbk.leet
package slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SlidingWindowMedianSpec extends AnyFlatSpec with Matchers {

    "SlidingWindowMedianSpec.medianSlidingWindow([1,3,-1,-3,5,3,6,7], 3)" should "[1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]" in {
        new SlidingWindowMedianNaive().medianSlidingWindowNaive(Array(1,3,-1,-3,5,3,6,7), 3) should
          equal (Array(1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000))

        new SlidingWindowMedian().medianSlidingWindow(Array(1,3,-1,-3,5,3,6,7), 3) should
          equal (Array(1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000))
    }

    "SlidingWindowMedianSpec.medianSlidingWindow([1,4,2,3], 4)" should "[2.50000]" in {
        new SlidingWindowMedianNaive().medianSlidingWindowNaive(Array(1,4,2,3), 4) should equal (Array(2.50000))
        new SlidingWindowMedian().medianSlidingWindow(Array(1,4,2,3), 4) should equal (Array(2.50000))
    }

    "SlidingWindowMedianSpec.medianSlidingWindow([2147483647,2147483647], 2)" should "[2147483647]" in {
        new SlidingWindowMedianNaive().medianSlidingWindowNaive(Array(2147483647,2147483647), 2) should equal (Array(2147483647))
        new SlidingWindowMedian().medianSlidingWindow(Array(2147483647,2147483647), 2) should equal (Array(2147483647))
    }
}
