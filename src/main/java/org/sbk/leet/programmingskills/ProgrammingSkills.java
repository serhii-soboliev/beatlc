package org.sbk.leet.programmingskills;

import java.util.ArrayList;
import java.util.List;

/*
191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/
 */
public class ProgrammingSkills {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }

    /*
    1281. Subtract the Product and Sum of Digits of an Integer
    https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
     */
    public int subtractProductAndSum(int n) {
        List<Integer> digits = new ArrayList<>();

        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }

        int prod = digits.stream().reduce(1, (a, b) -> a * b);
        int sum = digits.stream().reduce(0, Integer::sum);
        return prod - sum;
    }

    public static void main(String[] args) {
        System.out.println(new ProgrammingSkills().subtractProductAndSum(234));
    }
}
