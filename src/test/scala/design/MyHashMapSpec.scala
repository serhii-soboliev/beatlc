package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class MyHashMapSpec extends AnyFlatSpec with Matchers {

    "MyHashMap" should "scenario 1" in {
        val myHashMap = new MyHashMap()
        myHashMap.put(0,1)
        myHashMap.put(1,2)
        myHashMap.get(0) should be (1)
        myHashMap.get(1) should be (2)
        myHashMap.get(2) should be (-1)
        myHashMap.remove(1)
        myHashMap.get(1) should be (-1)
        myHashMap.get(10) should be (-1)
        myHashMap.remove(15)
    }

    "MyHashMap" should "scenario 2" in {
        val myHashMap = new MyHashMap()
        myHashMap.put(1,1)
        myHashMap.put(2,2)
        myHashMap.get(1) should be (1)
        myHashMap.get(3) should be (-1)
        myHashMap.put(2,1)
        myHashMap.get(2) should be (1)
        myHashMap.remove(2)
        myHashMap.get(2) should be (-1)

    }

}
