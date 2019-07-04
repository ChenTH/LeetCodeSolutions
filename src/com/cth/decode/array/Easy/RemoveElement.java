package com.cth.decode.array.Easy;

public class RemoveElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int flag = nums.length - 1;
        for (i = 0; i < flag; i++) {
            if (nums[i] == val) {
                int exchange = nums[i];
                nums[i] = nums[flag];
                nums[flag] = exchange;
                flag--;
                if (nums[i] == val) {
                    i--;
                }
            }
        }
        return i;

    }

}
