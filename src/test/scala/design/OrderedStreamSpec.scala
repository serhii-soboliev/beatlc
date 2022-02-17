package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class OrderedStreamSpec  extends AnyFlatSpec with Matchers {

    "OrderedStream" should "scenario 1" in {
        val os = new OrderedStream(5)
        os.insert(3, "ccccc") should be (List())
        os.insert(1, "aaaaa") should be (List("aaaaa"))
        os.insert(2, "bbbbb") should be (List("bbbbb", "ccccc"))
        os.insert(5, "eeeee") should be (List())
        os.insert(4, "ddddd") should be (List("ddddd", "eeeee"))
    }

}
