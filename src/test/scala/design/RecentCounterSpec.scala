package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RecentCounterSpec extends AnyFlatSpec with Matchers {

    "RecentCounter" should "scenario 1" in {
        val recentCounter = new RecentCounter
        recentCounter.ping(1) should equal (1)
        recentCounter.ping(100) should equal (2)
        recentCounter.ping(3001) should equal (3)
        recentCounter.ping(3002) should equal (3)

    }
}
