package org.sbk.leet
package arraysandstringschapter


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ProductOfArrayExceptSelfSpec extends AnyFlatSpec with Matchers{

    "productExceptSelf(1,2,3,4)" should "Array(24,12,8,6)" in {
        val pes = new ProductOfArrayExceptSelf()
        pes.productExceptSelf(Array(1,2,3,4)) should equal (Array(24,12,8,6))
    }

    "productExceptSelf(-1,1,0,-3,3)" should "Array(0,0,9,0,0)" in {
        val pes = new ProductOfArrayExceptSelf()
        pes.productExceptSelf(Array(-1,1,0,-3,3)) should equal (Array(0,0,9,0,0))
    }


}
