package org.sbk.leet.programmingskills;
/*
191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }
}
