package org.sbk.leet
package slidingwindow

import scala.collection.mutable

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestSubstringWithoutRepeatingCharacters {

    def lengthOfLongestSubstringOptimized(s: String): Int = {
        import scala.collection.mutable
        var lsl = 0
        val map = new mutable.HashMap[Char, Int]()
        var i = 0
        (0 until s.length) foreach(
          j=> {
                if (map.contains(s(j))) {
                    i = Math.max(map.getOrElse(s(j), 0), i)
                }
                lsl = Math.max(lsl, j - i + 1)
                map.put(s(j), j + 1)
            }
          )
        lsl
    }


    def lengthOfLongestSubstringNaive(s: String): Int = {
        import scala.collection.mutable
        import scala.util.control.Breaks.{break, breakable}
        var lsl = 0
        var startIdx = 0
        while (startIdx < s.length) {
            val lastSymbolIdx = new mutable.HashMap[Char, Int]()
            breakable {
                (startIdx until s.length) foreach (
                  i => {
                      val c = s(i)
                      if (lastSymbolIdx.contains(c)) {
                          val lastIndex = lastSymbolIdx.getOrElse(c, 0)
                          lsl = Math.max(lsl, i - startIdx)
                          startIdx = lastIndex + 1
                          break
                      }
                      lastSymbolIdx(c) = i
                  }
                  )
                lsl = Math.max(lsl, s.length - startIdx)
                startIdx = s.length
            }
        }
        lsl
    }

}
