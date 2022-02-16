package org.sbk.leet
package design

/*
146. LRU Cache
https://leetcode.com/problems/lru-cache/
 */
class LRUCacheListBuffer(capacity: Int) {

    import scala.collection.mutable.ListBuffer

    private var cache: ListBuffer[(Int, Int)] = new ListBuffer()

    def get(key: Int): Int = {
        val i = find(key)
        if(i != -1) {
            val (k, v) = cache(i)
            cache.remove(i)
            cache = (k,v) +: cache
            return v
        }
        -1
    }

    private def find(key: Int) : Int = {
        cache.indexWhere(v => v._1 == key)
    }

    def put(key: Int, value: Int): Unit = {
        val i = find(key)
        if(i != -1) {
            cache.remove(i)
        } else if (cache.size == capacity) {
            cache.remove(cache.size -1)
        }
        cache = (key,value) +: cache
    }

}
