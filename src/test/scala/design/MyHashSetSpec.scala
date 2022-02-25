package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class MyHashSetSpec extends AnyFlatSpec with Matchers {

    "MyHashSet" should "scenario 1" in {
        val myHashSet = new MyHashSet()
        myHashSet.add(1)
        myHashSet.add(2)
        myHashSet.contains(1) should be (true)
        myHashSet.contains(3) should be (false)
        myHashSet.add(2)
        myHashSet.contains(2) should be (true)
        myHashSet.remove(2)
        myHashSet.contains(2) should be (false)
    }


}
