package org.sbk.leet.backtracking;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
40. Combination Sum II
https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    private TreeMap<Integer, Long> counter;
    private List<Integer> counterKeys;
    private final List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> currentCombination = new ArrayList<>();
        counter = new TreeMap<> (Arrays
                .stream(candidates)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ));
        counterKeys = new ArrayList<>(counter.keySet());
        backtrack(currentCombination, 0, target);
        return results;
    }

    private void backtrack(List<Integer> currentCombination,
                           int currentKeyIndex,
                           int remain) {
        if(remain <= 0) {
            if(remain == 0) {
                results.add(currentCombination);
            }
            return;
        }
        for(int i = currentKeyIndex; i<counterKeys.size(); i++) {
            Integer key = counterKeys.get(i);
            Long freq = counter.get(key);
            if(freq <= 0) {
                continue;
            }
            counter.put(key, freq-1);
            List<Integer> newCombination = new ArrayList<>(currentCombination);
            newCombination.add(key);
            backtrack(newCombination, i, remain - key);
            counter.put(key, freq);
        }

    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(new CombinationSumII().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
