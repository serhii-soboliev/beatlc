package org.sbk.leet
package slidingwindow

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestSubstringWithoutRepeatingCharacters {

    def lengthOfLongestSubstringNaive(s: String): Int = {
        import scala.collection.mutable
        import scala.util.control.Breaks.{break, breakable}
        var lsl = 0
        var startIdx = 0
        while (startIdx < s.length) {
            val lastSymbolIdx: mutable.Map[Char, Int] = new mutable.HashMap[Char, Int]()
            breakable {
                (startIdx until s.length) foreach (
                  i => {
                      val c: Char = s(i)
                      if (lastSymbolIdx.contains(c)) {
                          val lastIndex: Int = lastSymbolIdx.getOrElse(c, 0)
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
