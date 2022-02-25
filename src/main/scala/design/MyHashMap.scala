package org.sbk.leet
package design

import scala.collection.mutable.ListBuffer

/*
706. Design HashMap
https://leetcode.com/problems/design-hashmap/
 */
class MyHashMap {
    private val cardinality = 128
    private val buckets = Array.fill[ListBuffer[(Int, Int)]](cardinality)(ListBuffer.empty[(Int, Int)])

    def put(key: Int, value: Int): Unit = {
        val idx = getBucketIndex(key)
        get(key) match {
            case -1 => buckets(idx).append((key, value))
            case _ =>  buckets(idx).find{case (k,_) => k == key}.map{
                case (_, _) =>
                    remove(key)
                    buckets(idx).append((key, value))
            }
        }
    }

    def get(key: Int): Int = {
        buckets(getBucketIndex(key))
          .find{case (k,_) => k == key}
          .map{case (_,v) => v}
          .getOrElse(-1)
    }

    def remove(key: Int): Unit = {
        val idx = getBucketIndex(key)
        buckets(idx).filter{case(k,_) => k == key}.map(v=> {
            buckets(idx)  -= v
        })
    }

    private def getBucketIndex(key: Int): Int = {
        key.hashCode() % cardinality
    }
}
