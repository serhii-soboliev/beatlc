package org.sbk.leet.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
51. N-Queens
52. N-Queens II
https://leetcode.com/problems/n-queens/
https://leetcode.com/problems/n-queens-ii/
 */
public class NQueens {

    record Field(int x, int y){ }

    public List<List<String>> solveNQueens(int n) {
        List<List<Field>> results = new ArrayList<>();
        placeQueens(new ArrayList<>(), results, n);
        return results
                .stream()
                .map(fields -> fieldsToStrings(fields, n))
                .collect(Collectors.toList());
    }

    private List<String> fieldsToStrings(List<Field> fields, int n) {
        return fields
                .stream()
                .map(f -> fieldToString(f, n))
                .collect(Collectors.toList());
    }

    private String fieldToString(Field f, int n) {
        return ".".repeat(f.x) + "Q" + ".".repeat(n - f.x - 1);
    }

    public int totalNQueens(int n) {
        List<List<Field>> results = new ArrayList<>();
        placeQueens(new ArrayList<>(), results, n);
        return results.size();
    }

    private void placeQueens(List<Field> placedQueens, List<List<Field>> results, int n) {
        if(placedQueens.size() == n) {
            results.add(placedQueens);
            return;
        }
        int newQueenNumber = placedQueens.size();

        for(int i = 0; i < n; i++) {
            Field newQueen = new Field(i, newQueenNumber);
            boolean legal = placedQueens.stream().noneMatch(placedQueen -> couldHit(newQueen, placedQueen));
            if(legal) {
                List<Field> newPlacedQueens = new ArrayList<>(placedQueens);
                newPlacedQueens.add(newQueen);
                placeQueens(newPlacedQueens, results, n);
            }

        }

    }

    private boolean couldHit(Field f1, Field f2) {
        return     f1.x == f2.x
                || f1.y == f2.y
                || Math.abs(f1.x - f2.x) == Math.abs(f1.y - f2.y);
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(5).forEach(System.out::println);
    }

}
