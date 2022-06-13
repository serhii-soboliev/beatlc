package org.sbk.leet.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
17. Letter Combinations of a Phone Number
https://www.youtube.com/watch?v=S3XqYA5F9Gk
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] digitsToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.isBlank()) return new ArrayList<>();
        List<String> result = List.of("");
        List<Integer> digitsInts = Arrays.stream(digits.split("")).map(Integer::parseInt).collect(Collectors.toList());
        for(int i : digitsInts){
            String[] symbols = digitsToChars[i].split("");
            List<String> newResult = new ArrayList<>();
            result.forEach(r -> {
                for(String symbol : symbols) {
                    String newR = r + symbol;
                    newResult.add(newR);
                }
            });
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations(""));
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("2"));
    }
}
