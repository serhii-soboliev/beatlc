package org.sbk.leet.backtracking;

import java.util.Arrays;

/*
300. Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        return Arrays.stream(lis).max().orElse(0);
    }


    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{4,10,4,3,8,9}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
