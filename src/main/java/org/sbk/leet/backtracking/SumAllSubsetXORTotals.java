package org.sbk.leet.backtracking;

import java.util.ArrayList;
import java.util.List;

/*

1863. Sum of All Subset XOR Totals
https://leetcode.com/problems/sum-of-all-subset-xor-totals/submissions/

 */
public class SumAllSubsetXORTotals {

    int res = 0;

    public int subsetXORSum(int[] nums) {

        List<Integer> l = new ArrayList<>();
        l.add(0);
        for(int i=0; i<nums.length; i++) {
            int num = 1 << i;
            int right = l.size() - 1;
            int left = Math.max(l.size()-num, 0);
            for(int j = right; j >= left; j--) {
                int v = l.get(j);
                l.add(v ^ nums[i]);
                l.add(v);
            }
        }
        return l.subList(l.size()  -(1 << nums.length), l.size())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

    public static void main(String[] args) {
        System.out.println(new SumAllSubsetXORTotals().subsetXORSum(new int[]{5, 1, 6}));
    }

    public int subsetXORSum_1(int[] nums) {
        solve(nums, 0, 0);
        return res;

    }

    private void solve(int[] nums, int index, int currRes) {
        if(index == nums.length) {
            res += currRes;
            return;
        }
        solve(nums, index+1, currRes ^ nums[index]);
        solve(nums, index+1, currRes);
    }
}
