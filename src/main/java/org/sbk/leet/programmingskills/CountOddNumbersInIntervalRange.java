package org.sbk.leet.programmingskills;

import java.util.stream.IntStream;

/*
1523. Count Odd Numbers in an Interval Range
https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */
public class CountOddNumbersInIntervalRange {

    public int countOdds_(int low, int high) {
        return (int) IntStream.range(low, high+1).filter(k -> k % 2 == 1).count();
    }

    public int countOdds(int low, int high) {
        if(low % 2 == 0) low = low + 1;
        int c = high - low;
        return c < 0 ? 0 : c / 2 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new CountOddNumbersInIntervalRange().countOdds(3, 7));
        System.out.println(new CountOddNumbersInIntervalRange().countOdds(21, 22));
    }
}
