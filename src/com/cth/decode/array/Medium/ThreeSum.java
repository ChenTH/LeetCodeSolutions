package com.cth.decode.array.Medium;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    //    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            List<List<Integer>> resPart = twoSum(nums, 0 - nums[i], i);
//            res.addAll(resPart);
//        }
//        return res;
//    }
//
//    public List<List<Integer>> twoSum(int[] nums, int target, int idx) {
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (i != idx) {
//                if(map.containsKey(target-nums[i])){
//
//                }
//                List<Integer> list = null;
//                if (map.containsKey(nums[i])) {
//                    list = map.get(nums[i]);
//                } else {
//                    list = new ArrayList<Integer>();
//                }
//                list.add(i);
//                map.put(nums[i], list);
//            }
//        }
//        return res;
//    }
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
