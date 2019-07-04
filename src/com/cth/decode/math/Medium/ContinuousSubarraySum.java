package com.cth.decode.math.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {0, 1, 0};
        System.out.println(checkSubarraySum(nums, 0));
        System.out.println(checkSubarraySum2(nums, 0));
        System.out.println(checkSubarraySum3(nums, 0));
        System.out.println(checkSubarraySum4(nums, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int[][] sum = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum[i][j] = sum[i][j - 1] + nums[j];
                if (k == 0 && sum[i][j] == 0) {
                    return true;
                } else if (k != 0 && sum[i][j] % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum[j] = sum[j - 1] + nums[j];
                if (k == 0 && sum[j] == 0) {
                    return true;
                } else if (k != 0 && sum[j] % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkSubarraySum3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = (k == 0 ? sum : sum % k);
            if (map.containsKey(t)) {
                if (i - map.get(t) > 1) {
                    return true;
                }
            } else {
                map.put(t, i);
            }
        }
        return false;
    }

    public static boolean checkSubarraySum4(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, pre = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t = (k == 0 ? sum : sum % k);
            if (set.contains(t)) {
                return true;
            } else {
                set.add(pre);
                pre = t;
            }
        }
        return false;
    }
}
