package org.sbk.leet.programmingskills;

import java.util.Arrays;

/*
1491. Average Salary Excluding the Minimum and Maximum Salary
https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class AverageSalary {
    public double average(int[] salary) {
        int min = Arrays.stream(salary).min().getAsInt();
        int max = Arrays.stream(salary).max().getAsInt();
        int sum = Arrays.stream(salary).sum();
        return (double)(sum - min - max)/(salary.length-2);
    }
}
