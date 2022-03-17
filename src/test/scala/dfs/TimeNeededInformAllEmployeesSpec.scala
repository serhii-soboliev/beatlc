package org.sbk.leet
package dfs

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TimeNeededInformAllEmployeesSpec extends AnyFlatSpec with Matchers {

    "n = 1, headID = 0, manager = [-1], informTime = [0]" should "0" in {
        val ti = new TimeNeededInformAllEmployees()
        ti.numOfMinutes(1,0,Array(-1), Array(0)) should be (0)
    }

    "n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]" should "1" in {
        val ti = new TimeNeededInformAllEmployees()
        ti.numOfMinutes(6,2,Array(2,2,-1,2,2,2), Array(0,0,1,0,0,0)) should be (1)
    }

    "n = 6, headID = 2, manager = [2,3,-1,2,2,2], informTime = [0,1,1,0,0,0]" should "2" in {
        val ti = new TimeNeededInformAllEmployees()
        ti.numOfMinutes(6,2,Array(2,3,-1,2,2,2), Array(0,1,1,0,0,0)) should be (2)
    }

}
