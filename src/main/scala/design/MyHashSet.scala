package org.sbk.leet
package design

import scala.collection.mutable

/*
705. Design HashSet
https://leetcode.com/problems/design-hashset/
 */
class MyHashSet {

    private val cardinality = 2048
    private val buckets = Array.fill[mutable.Set[Int]](cardinality)(mutable.Set.empty[Int])
    private def bucketIndex(key: Int) = key.hashCode() % cardinality

    def add(key: Int): Unit = {
        buckets(bucketIndex(key)) += key
    }

    def remove(key: Int): Unit = {
        buckets(bucketIndex(key)) -= key
    }

    def contains(key: Int): Boolean = {
        buckets(bucketIndex(key)).contains(key)
    }

}
