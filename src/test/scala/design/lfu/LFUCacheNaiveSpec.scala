package org.sbk.leet
package design.lfu

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class LFUCacheNaiveSpec extends AnyFlatSpec with Matchers{

    "LFUCacheNaive" should "scenario 1" in {
        val lfuCache = new LFUCacheNaive(2)
        lfuCache.put(1,1)
        lfuCache.put(2,2)
        lfuCache.get(1) should equal(1)
        lfuCache.put(3,3)
        lfuCache.get(2) should equal(-1)
        lfuCache.get(3) should equal(3)
        lfuCache.put(4,4)
        lfuCache.get(1) should equal(-1)
        lfuCache.get(3) should equal(3)
        lfuCache.get(4) should equal(4)
    }

    "LFUCacheNaive" should "scenario 2" in {
        val lfuCache = new LFUCacheNaive(2)
        lfuCache.put(3,1)
        lfuCache.put(2,1)
        lfuCache.put(2,2)
        lfuCache.put(4,4)
        lfuCache.get(2) should equal(2)
    }

    "LFUCacheNaive" should "scenario 3" in {
        val lfuCache = new LFUCacheNaive(0)
        lfuCache.put(0,0)
        lfuCache.get(0) should equal(-1)
    }

    "LFUCacheNaive" should "scenario 4" in {
        val lfuCache = new LFUCacheNaive(2)
        lfuCache.put(2,1)
        lfuCache.put(3,2)
        lfuCache.get(3) should equal(2)
        lfuCache.get(2) should equal(1)
        lfuCache.put(4,3)
        lfuCache.get(2) should equal(1)
        lfuCache.get(3) should equal(-1)
        lfuCache.get(4) should equal(3)
    }


}
