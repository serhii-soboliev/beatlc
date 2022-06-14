package org.sbk.leet.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(),0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder cur, int opened, int closed, int max) {
        if(cur.length() == 2 * max) {
            result.add(cur.toString());
            return;
        }
        if(opened < max) {
            backtrack(result, new StringBuilder(cur).append("("), opened + 1, closed, max);
        }

        if(closed < opened) {
            backtrack(result,  new StringBuilder(cur).append(")"), opened, closed + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
