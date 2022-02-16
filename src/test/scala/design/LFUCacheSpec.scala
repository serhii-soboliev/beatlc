package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LFUCacheSpec extends AnyFlatSpec with Matchers{

    "LFUCache" should "scenario 0" in {
        val lfuCache = new LFUCache(3)
        lfuCache.put(2,2)
        lfuCache.put(1,1)
        lfuCache.get(2) should equal(2)
        lfuCache.get(1) should equal(1)
        lfuCache.get(2) should equal(2)
        lfuCache.put(3,3)
        lfuCache.put(4,4)
        lfuCache.get(3) should equal(3)
        lfuCache.get(4) should equal(4)
    }

    "LFUCache" should "scenario 1" in {
        val lfuCache = new LFUCache(2)
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

    "LFUCache" should "scenario 2" in {
        val lfuCache = new LFUCache(2)
        lfuCache.put(3,1)
        lfuCache.put(2,1)
        lfuCache.put(2,2)
        lfuCache.put(4,4)
        lfuCache.get(2) should equal(2)
    }

    "LFUCache" should "scenario 3" in {
        val lfuCache = new LFUCache(0)
        lfuCache.put(0,0)
        lfuCache.get(0) should equal(-1)
    }

    "LFUCache" should "scenario 4" in {
        val lfuCache = new LFUCache(2)
        lfuCache.put(2,1)
        lfuCache.put(3,2)
        lfuCache.get(3) should equal(2)
        lfuCache.get(2) should equal(1)
        lfuCache.put(4,3)
        lfuCache.get(2) should equal(1)
        lfuCache.get(3) should equal(-1)
        lfuCache.get(4) should equal(3)
    }

    "LFUCache" should "scenario 5" in {
        val lfuCache = new LFUCache(1)
        lfuCache.put(2,1)
        lfuCache.get(2) should equal(1)
        lfuCache.put(3,2)
        lfuCache.get(2) should equal(-1)
        lfuCache.get(3) should equal(2)
    }

    "LFUCache" should "scenario 6" in {
        val lfuCache = new LFUCache(2)
        lfuCache.get(2) should equal(-1)
        lfuCache.put(2,6)
        lfuCache.get(1) should equal(-1)
        lfuCache.put(1,5)
        lfuCache.put(1,2)
        lfuCache.get(1) should equal (2)
        lfuCache.get(2) should equal (6)
    }


}
