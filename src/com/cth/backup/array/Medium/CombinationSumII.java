package com.cth.backup.array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(set, new ArrayList<>(), nums, target, 0);
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    private void backtrack(Set<List<Integer>> set, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) set.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(set, tempList, nums, remain - nums[i], i + 1); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
