package org.sbk.leet
package hashtables

/*
923. 3Sum With Multiplicity
https://leetcode.com/problems/3sum-with-multiplicity/
 */
class TreeSumWithMultiplicity {

    def threeSumMulti(arr: Array[Int], target: Int): Int = {
        val occurrence = arr.zipWithIndex.toList.groupMap { case (x, _) => x } { case (_, y) => y }
        val numberSet = occurrence.keys.toList
        val tuples = for {
            i <- numberSet
            j <- numberSet if j >= i
            tk = target - i - j
            s1 = occurrence(i).size.toLong
            s2 = occurrence(j).size.toLong
            count =
              if (tk < j) 0L
              else
                  occurrence.get(tk) match {
                      case None => 0L
                      case Some(l) =>
                          val sl = l.size.toLong
                          if (i == j && j == tk) {
                              if (s1 < 3) 0L else (s1 - 2) * (s1 - 1) * s1 / 6
                          } else if (i == j) {
                              if (s1 < 2) 0L else s1 * (s1 - 1) / 2 * sl
                          } else if (j == tk) {
                              if (s2 < 2) 0L else s2 * (s2 - 1) / 2 * s1
                          } else {
                              s1 * s2 * sl
                          }
                  }
        } yield count
        (tuples.sum % (1e9 + 7)).toInt
    }
}
