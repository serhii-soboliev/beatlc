package org.sbk.leet.programmingskills;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /*
    976. Largest Perimeter Triangle
    https://leetcode.com/problems/largest-perimeter-triangle/
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i >=2; i-- ) {
            if(nums[i] < nums[i-1] + nums[i-2]) return nums[i] + nums[i-1] + nums[i-2];
        }
        return 0;
    }

    /*
    1779. Find Nearest Point That Has the Same X or Y Coordinate
    https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
     */
    public int nearestValidPoint(int x, int y, int[][] p) {
        return IntStream.range(0, p.length)
                .mapToObj(i -> new int[]{p[i][0], p[i][1], i, Math.abs(x - p[i][0]) + Math.abs(y - p[i][1])})
                .filter(v -> v[0] == x || v[1] == y)
                .sorted(Comparator.comparingInt(o -> o[3]))
                .map(v -> v[2])
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(new ProgrammingSkills().nearestValidPoint(3, 4, new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}}));
        System.out.println(new ProgrammingSkills().nearestValidPoint(3, 4, new int[][]{{1,2}}));
    }
}
