package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class LRUCacheLinkedHashMapSpec extends AnyFlatSpec with Matchers{

    "LRUCacheSpec" should "scenario 1" in {
        val lRUCache = new LRUCacheLinkedHashMap(2)
        lRUCache.put(1, 1)
        lRUCache.put(2, 2)
        lRUCache.get(1) should equal (1)
        lRUCache.put(3, 3)
        lRUCache.get(2) should equal (-1)
        lRUCache.put(4, 4)
        lRUCache.get(1) should equal (-1)
        lRUCache.get(3) should equal (3)
        lRUCache.get(4) should equal (4)
    }

    "LRUCacheSpec" should "scenario 2" in {
        val lRUCache = new LRUCacheLinkedHashMap(2)
        lRUCache.get(2)
        lRUCache.put(2, 6)
        lRUCache.get(1) should equal (-1)
        lRUCache.put(1, 5)
        lRUCache.put(1, 2)
        lRUCache.get(1) should equal (2)
        lRUCache.get(2) should equal (6)
    }

    "LRUCacheSpec" should "scenario 3" in {
        val lRUCache = new LRUCacheLinkedHashMap(2)
        lRUCache.put(2, 1)
        lRUCache.put(1, 1)
        lRUCache.put(2, 3)
        lRUCache.put(4, 1)
        lRUCache.get(1) should equal (-1)
        lRUCache.get(2) should equal (3)
    }


}
