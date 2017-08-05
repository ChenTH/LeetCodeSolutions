package com.cth.decode.array.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SherlockTHao on 2017/8/5.
 */
public class ArrayNesting {
    //解法1
    public static int arrayNesting(int[] nums) {
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            int next = nums[i];
            while (!set.contains(next)) {
                set.add(next);
                next = nums[next];
            }
            counts[i] = set.size();
        }
        int result = 0;
        for (Integer i : counts) {
            if (i > result) {
                result = i;

            }
        }
        return result;
    }

    //解法2
    public static int arrayNesting2(int[] nums) {
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
            int size=0;
            for(int j=i;nums[j]>-1;size++){
                int tmp=nums[j];
                nums[j]=-1;
                j=tmp;
            }
            maxCount=Integer.max(maxCount,size);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(arrayNesting2(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}
