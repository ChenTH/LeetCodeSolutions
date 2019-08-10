package com.cth.backup.array.Easy;

import java.util.*;

/**
 * Created by SherlockTHao on 2017/5/15.
 */
public class KdiffPairsinanArray {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        findPairs(nums, 2);
    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int result = 0;
        for (Integer num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) >= 2) {
                    result++;
                }
            } else {
                if (map.containsKey(num + k)) {
                    result++;
                }
            }
        }
        return result;
    }

}
