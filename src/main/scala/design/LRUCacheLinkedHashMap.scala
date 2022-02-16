package org.sbk.leet
package design

/*
146. LRU Cache
https://leetcode.com/problems/lru-cache/
 */
class LRUCacheLinkedHashMap(capacity: Int) {
    import scala.collection.mutable

    private val cache = new mutable.LinkedHashMap[Int, Int]()

    def get(key: Int): Int = {
        cache.get(key).map({ v =>
            cache.remove(key)
            cache(key) = v
            return v
        }).getOrElse(-1)
    }

    def put(key: Int, value: Int): Unit = {
        cache.remove(key)
        cache(key) = value
        if (cache.size > capacity) {
            cache.remove(cache.head._1)
        }
    }
}
