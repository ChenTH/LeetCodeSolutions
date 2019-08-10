package com.cth.backup.array.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by SherlockTHao on 2017/8/2.
 */
public class triangleNumber {
    //�ⷨ1ʱ�临�Ӷ�̫��TML��
    public static int triangleNumber(int[] nums) {
        int[] count = {0};
        List<Integer> list = new ArrayList<>();
        getTriangle(nums, list, count, 0);
        return count[0];
    }

    public static void getTriangle(int[] nums, List<Integer> list, int[] count, int index) {
        if (list.size() < 3) {
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                getTriangle(nums, list, count, i + 1);
                list.remove(list.size() - 1);
            }
        } else {
            if (list.size() >= 3) {
                if (judgeTriangle(list)) {
                    count[0]++;
                }
            }
        }

    }

    public static boolean judgeTriangle(List<Integer> list) {
        if (!(list.get(0) + list.get(1) > list.get(2) && Math.abs(list.get(0) - list.get(1)) < list.get(2))) {
            return false;
        }
        if (!(list.get(2) + list.get(1) > list.get(0) && Math.abs(list.get(2) - list.get(1)) < list.get(0))) {
            return false;
        }
        if (!(list.get(0) + list.get(2) > list.get(1) && Math.abs(list.get(0) - list.get(2)) < list.get(1))) {
            return false;
        }
        return true;
    }

    //�ⷨ2�����������һ��ֵ
    public static int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int index = BinarySearch(nums[i] + nums[j], j + 1, nums.length - 1, nums);
                res += index - j;
            }
        }
        return res;
    }

    public static int BinarySearch(int sum, int beg, int end, int[] nums) {
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (nums[mid] < sum) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    //�ⷨ3
    public static int triangleNumber3(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int tem = j + 1;
                for (int k = tem; k < nums.length; k++) {
                    if (nums[k] < nums[i] + nums[j]) {
                        tem++;
                    } else {
                        break;
                    }
                }
                res += tem - j - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.print(triangleNumber3(new int[]{2, 2, 3, 4}));
    }
}
