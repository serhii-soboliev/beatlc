package org.sbk.leet
package slidingwindow

import scala.collection.mutable

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestSubstringWithoutRepeatingCharacters {

    def lengthOfLongestSubstring(s: String): Int = {
        val indices = mutable.Map[Char, Int]()
        var left = 0
        var longest = 0
        for ((char, right) <- s.zipWithIndex) {
            indices get char match {
                case None =>
                case Some(i) => left = left max (i + 1)
            }
            longest = longest max (right - left + 1)
            indices.put(char, right)
        }
        longest
    }

    def lengthOfLongestSubstringScala(s: String): Int = {

        val visited = scala.collection.mutable.Map[Char, Integer]()

        val (ans, _) = s.indices.foldLeft(0, 0) {
            case ((result, begin), idx) if !visited.contains(s(idx)) =>
                visited += (s(idx) -> idx)
                (Math.max(result, idx + 1 - begin), begin)

            case ((result, begin), idx) =>
                // Since we are doing a Map, it is likely a reoccurence can occur for a character
                // prior to the current begin index. Hence, we take a max of indexes.
                val old = Math.max(visited(s(idx)) + 1, begin)
                visited += (s(idx) -> idx)
                (Math.max(result, idx - old + 1), old)
        }

        ans
    }

    def lengthOfLongestSubstringOptimized(s: String): Int = {
        import scala.collection.mutable
        var lsl = 0
        val map = new mutable.HashMap[Char, Int]()
        var i = 0
        for ((c, j) <- s.zipWithIndex) {
            if (map.contains(c)) i = map.getOrElse(c, 0) max i
            lsl = lsl max j - i + 1
            map(c) =  j + 1
        }
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
