package org.sbk.leet.backtracking;

import java.util.HashSet;
import java.util.Set;

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestIncreasingSubsequenceWORepeat {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int res = Integer.MIN_VALUE;
        int n = s.length();
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++) {
            res = Math.max(res, getLengthOfLongestSubstFromPoint(n, chars, i));
        }
        return res;
    }

    private int getLengthOfLongestSubstFromPoint(int n, char[] chars, int i) {
        Set<Character> curChars = new HashSet<>();
        for(int j = i; j < n; j++) {
            if(curChars.contains(chars[j])) {
                return j - i;
            } else {
                curChars.add(chars[j]);
            }
        }
        return n - i;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequenceWORepeat().lengthOfLongestSubstring(" "));
        System.out.println(new LongestIncreasingSubsequenceWORepeat().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestIncreasingSubsequenceWORepeat().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestIncreasingSubsequenceWORepeat().lengthOfLongestSubstring("pwwkew"));
    }


}
