package org.sbk.leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public boolean doesSubsetExist(List<Integer> l, int n) {
        if(n == 0) {
            return true;
        }
        if(n < 0 || l.isEmpty()) {
            return false;
        }
        Integer x = l.get(0);
        List<Integer> lCopy1 = new ArrayList<>(l);
        List<Integer> lCopy2 = new ArrayList<>(l);
        lCopy1.remove(x);
        lCopy2.remove(x);
        return doesSubsetExist(lCopy1, n - x) || doesSubsetExist(lCopy2, n);
    }

    public static void main(String[] args) {
        System.out.println(new SubsetSum().doesSubsetExist(List.of(8,6,7,5,3,10,9), 15));
        System.out.println(new SubsetSum().doesSubsetExist(List.of(11,6,5,1,7,13,12), 15));
    }
}
