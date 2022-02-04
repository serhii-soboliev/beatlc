package org.sbk.leet
package slidingwindow


/*
219. Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/
 */
class ContainsDuplicateII {

    def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
        import scala.collection.mutable
        val map = mutable.HashMap.empty[Int, List[Int]]

        nums.zipWithIndex.exists {
            case (num, i) =>
                map
                  .get(num)
                  .fold {
                      map.put(num, List(i))
                      false
                  } { ids =>
                      ids
                        .find(j => Math.abs(j - i) <= k)
                        .fold {
                            map.put(num, ids :+ i)
                            false
                        }(_ => true)
                  }
        }
    }

    def containsNearbyDuplicateSliding(nums: Array[Int], k: Int): Boolean = {
        import scala.collection.mutable
        var (fi, li) = (0, Math.min(k, nums.length - 1))

        val cnt: mutable.Map[Int, Int] = nums
          .slice(fi, li + 1)
          .groupBy(identity)
          .view
          .mapValues(_.length)
          .to(mutable.Map)

        if (cnt.values.exists(v => v > 1)) return true

        while (li < nums.length - 1) {
            cnt(nums(fi)) = cnt(nums(fi)) - 1
            fi += 1
            li += 1
            if (cnt.getOrElse(nums(li), 0) > 0) return true
            cnt(nums(li)) = 1
        }

        false
    }

    def containsNearbyDuplicateNaive(nums: Array[Int], k: Int): Boolean = {
        nums
          .sliding(k + 1)
          .exists(ar => ar.toSet.size != ar.length)
    }
}


