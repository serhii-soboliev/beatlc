package org.sbk.leet
package design.lfu

/*
460. LFU Cache
https://leetcode.com/problems/lfu-cache/
 */
class LFUCacheNaive(capacity: Int) {

    import scala.collection.mutable

    case class CacheValue(var value: Int, var usageCount: Int, var opNo: Int) extends Ordered[CacheValue] {
        override def compare(that: CacheValue): Int =
            this.usageCount - that.usageCount match {
                case 0 => this.opNo.compare(that.opNo)
                case other => other
            }
    }

    private val cache = new mutable.HashMap[Int, CacheValue]()
    private var opNo = 0

    def get(key: Int): Int = {
        if(capacity == 0) return -1
        cache.get(key).map({ v =>
            v.usageCount += 1
            opNo += 1
            v.opNo = opNo
            return v.value
        }).getOrElse(-1)
    }

    def put(key: Int, value: Int): Unit = {
        if(capacity == 0) return
        cache.get(key).map({ v =>
            v.value = value
            v.usageCount += 1
            opNo += 1
            v.opNo = opNo
        }).getOrElse({
            if(cache.size == capacity) evict()
            opNo += 1
            cache(key) = CacheValue(value, 1, opNo)
        })

    }

    def evict(): Unit = {
        if(cache.nonEmpty) cache.remove(cache.minBy(_._2)._1)
    }

}


