package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ParkingSystemSpec extends AnyFlatSpec with Matchers{

    "ParkingSystem" should "scenario " in {
        val ps = new ParkingSystem(1,1,0)
        ps.addCar(1) should be (true)
        ps.addCar(2) should be (true)
        ps.addCar(3) should be (false)
        ps.addCar(1) should be (false)
    }

}
