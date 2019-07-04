package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), k, n, 1);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start) {
        if (tempList.size() > k) return; /** no solution */
        else if (tempList.size() == k && remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                backtrack(list, tempList, k, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
