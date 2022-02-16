package org.sbk.leet
package design

/*
460. LFU Cache
https://leetcode.com/problems/lfu-cache/
 */
class LFUCache(capacity: Int) {

    import scala.collection.mutable

    private val cache = new mutable.HashMap[Int, Int]()
    private val keyUsageCount = new mutable.HashMap[Int, Int]()
    private val freqMap = new mutable.HashMap[Int, mutable.LinkedHashSet[Int]]()
    private var min = -1


    def get(key: Int): Int = {
        cache.get(key).map(v => {
            val count = keyUsageCount(key)
            keyUsageCount(key) = count + 1
            freqMap.getOrElse(count, new mutable.LinkedHashSet[Int]()).remove(key)
            if(count == min && freqMap.get(count).isEmpty) min += 1
            freqMap(min) = freqMap.getOrElse(min, new mutable.LinkedHashSet[Int]()) + key
            v
        }).getOrElse(-1)
    }

    def put(key: Int, value: Int): Unit = {
        if(capacity <= 0) return
        cache.get(key).map(_ => {
            cache(key) = value
            get(key)
            return
        })
        if(cache.size == capacity) {
            val evictKey = freqMap(min).head
            freqMap(min) -= evictKey
            keyUsageCount.remove(evictKey)
            cache.remove(evictKey)
        }
        cache(key) = value
        keyUsageCount(key) = 1
        min = 1
        freqMap(min) = freqMap.getOrElse(min, new mutable.LinkedHashSet[Int]()) + key
    }


}


