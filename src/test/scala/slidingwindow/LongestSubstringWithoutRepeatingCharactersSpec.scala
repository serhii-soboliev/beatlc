package org.sbk.leet
package slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LongestSubstringWithoutRepeatingCharactersSpec extends AnyFlatSpec with Matchers{

    "Longest Substring Without Repeating Characters of cdd" should "2" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala("cdd") should equal (2)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized("cdd") should equal (2)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive("cdd") should equal (2)
    }

    "Longest Substring Without Repeating Characters of tmmzuxt" should "5" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala("tmmzuxt") should equal (5)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized("tmmzuxt") should equal (5)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive("tmmzuxt") should equal (5)
    }

    "Longest Substring Without Repeating Characters of abba" should "2" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala("abba") should equal (2)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized("abba") should equal (2)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive("abba") should equal (2)
    }

    "Longest Substring Without Repeating Characters of ' '" should "1" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala(" ") should equal (1)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized(" ") should equal (1)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive(" ") should equal (1)
    }

    "Longest Substring Without Repeating Characters of abcabcbb" should "3" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala("abcabcbb") should equal (3)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized("abcabcbb") should equal (3)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive("abcabcbb") should equal (3)
    }

    "Longest Substring Without Repeating Characters of bbbbb" should "1" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala("bbbbb") should equal (1)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized("bbbbb") should equal (1)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive("bbbbb") should equal (1)
    }

    "Longest Substring Without Repeating Characters of pwwkew" should "3" in {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringScala("pwwkew") should equal (3)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimized("pwwkew") should equal (3)
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringNaive("pwwkew") should equal (3)
    }
}
