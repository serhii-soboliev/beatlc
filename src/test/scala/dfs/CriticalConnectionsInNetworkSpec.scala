package org.sbk.leet
package dfs

import org.scalatest.Ignore
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

@Ignore
class CriticalConnectionsInNetworkSpec extends AnyFlatSpec with Matchers {

    "CriticalConnectionsInNetwork" should "scenario #1" in {
        val ti = new CriticalConnectionsInNetwork()
        ti.criticalConnections(4, List(List(0,1),List(1,2),List(2,0),List(1,3))) should be (List(List(0,1)))
    }
}
