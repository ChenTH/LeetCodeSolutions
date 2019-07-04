package com.cth.decode.array.Easy;

import java.util.HashMap;
import java.util.Map;

public class MoveZeroes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {0, 1, 0, 0};
        int[] b = {0, 1, 0, 0};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        moveZeroes(a);
        moveZeroes2(b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(b[i]);
        }
    }

    public static void moveZeroes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(j, nums[i]);
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            nums[i] = map.get(i);
        }
        if (j != 0) {
            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }
}
