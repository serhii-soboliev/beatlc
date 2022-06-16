package org.sbk.leet.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
39. Combination Sum
https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        solve(results, new ArrayList<>(), 0, candidates, target);
        return results;
    }

    private void solve(List<List<Integer>> results, List<Integer> curCombination, int index,  int[] candidates, int target) {
        if(target == 0) {
            results.add(curCombination);
            return;
        }
        if (target < 0 || index == candidates.length){
            return;
        }

        solve(results, curCombination, index + 1, candidates, target);

        List<Integer> newCombination = new ArrayList<>(curCombination);
        newCombination.add(candidates[index]);
        solve(results, newCombination, index, candidates, target - candidates[index]);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
