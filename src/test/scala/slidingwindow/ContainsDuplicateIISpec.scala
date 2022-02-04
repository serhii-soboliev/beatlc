package org.sbk.leet
package slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ContainsDuplicateIISpec extends AnyFlatSpec with Matchers{

    "ContainsDuplicateIISpec.containsNearbyDuplicate([1,2,3,1], 3)" should "true" in {
        new ContainsDuplicateII().containsNearbyDuplicateNaive(Array(1,2,3,1), 3) should be (true)
        new ContainsDuplicateII().containsNearbyDuplicate(Array(1,2,3,1), 3) should be (true)
    }

    "ContainsDuplicateIISpec.containsNearbyDuplicate([1,0,1,1], 1)" should "true" in {
        new ContainsDuplicateII().containsNearbyDuplicateNaive(Array(1,0,1,1), 1) should be (true)
        new ContainsDuplicateII().containsNearbyDuplicate(Array(1,0,1,1), 1) should be (true)
    }

    "ContainsDuplicateIISpec.containsNearbyDuplicate([1,2,3,1,2,3], 2)" should "false" in {
        new ContainsDuplicateII().containsNearbyDuplicateNaive(Array(1,2,3,1,2,3), 2) should be (false)
        new ContainsDuplicateII().containsNearbyDuplicate(Array(1,2,3,1,2,3), 2) should be (false)
    }

    "ContainsDuplicateIISpec.containsNearbyDuplicate([1,2,1], 0)" should "false" in {
        new ContainsDuplicateII().containsNearbyDuplicateNaive(Array(1,2,1), 0) should be (false)
        new ContainsDuplicateII().containsNearbyDuplicate(Array(1,2,1), 0) should be (false)
    }

}
