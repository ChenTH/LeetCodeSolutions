package com.cth.decode.array;

/**
 * Created by SherlockTHao on 2017/5/15.
 */
public class TwoSumIIInputarrayissorted {
    public static void main(String[] args){

    }
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while (i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
            }
            else {
                j--;
            }
        }
        return null;
    }
}
