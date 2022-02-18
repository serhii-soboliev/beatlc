package org.sbk.leet
package design.lru

/*
146. LRU Cache
https://leetcode.com/problems/lru-cache/
 */
class LRUCacheLinkedHashMap(capacity: Int) {
    import scala.collection.mutable

    private val cache = new mutable.LinkedHashMap[Int, Int]()

    def get(key: Int):Int = cache.remove(key) match {
        case None => -1
        case Some(value) =>
            cache.put(key, value)
            value
    }

    def put(key: Int, value: Int): Unit = {
        cache.put(key, value)
        get(key)
        if (cache.size > capacity) cache.remove(cache.head._1)
    }
}
