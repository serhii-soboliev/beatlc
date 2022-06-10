package org.sbk.leet.backtracking;

/*
300. Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    int result;
    int getLIS(int[] nums, int n) {
        if(n == 1) {
            return 1;
        }
        int answer, endingPoint = 1;
        for(int i = 1; i < n; i++) {
            answer = getLIS(nums, i);
            if(nums[n - 1] > nums[i - 1] && answer > endingPoint - 1) {
                endingPoint = answer + 1;
            }
        }
        result = Math.max(result, endingPoint);
        return endingPoint;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        result = 1;
        getLIS(nums, n);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{4,10,4,3,8,9}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
