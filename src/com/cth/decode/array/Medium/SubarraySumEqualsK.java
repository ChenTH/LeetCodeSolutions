package com.cth.decode.array.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by SherlockTHao on 2017/5/15.
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {

        System.out.print(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int[] sums = new int[nums.length + 1];
        int res = 0;
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : sums) {
            if (map.containsKey(i - k)) {
                res += map.get(i - k);
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return res;
    }
}
