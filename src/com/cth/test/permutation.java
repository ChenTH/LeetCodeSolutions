package com.cth.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SherlockTHao on 2017/3/17.
 */
public class permutation {
    public static void main(String[] args){
//        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> list=new ArrayList<>();
        int[] nums={1,2,3};
//        perm(result,list,0,nums);
        permute(nums);
    }
//    public static void perm(List<List<Integer>> result,List<Integer> part,int start,int[] nums){
//        if(start==nums.length-1){
//            result.add(part);
//        }
//        for(int i=0;i<nums.length-start-1;i++){
//            int[] nums2=nums.clone();
//            List<Integer> list =new ArrayList<>();
//            list.addAll(part);
//            int temp=nums2[start];
//            nums2[start]=nums2[start+i];
//            nums2[start+i]=temp;
//            list.add(nums2[start]);
//            perm(result,list,start+1,nums2);
//        }
//    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        perm(list,new ArrayList<>(),0,nums);
        return list;
    }

    public static void perm(List<List<Integer>> res, List<Integer> list,int start, int[] nums) {
        if(start == nums.length) {
            List<Integer> li = new ArrayList<>();
            for(int i =0; i < nums.length; i++) {
                //li.add(nums[i]);
                System.out.print(nums[i] +"--");
            }
            System.out.println();
            res.add(li);
        }else {
            for(int i = start; i < nums.length; i++) {
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;

                perm(res,list,start+1,nums);

                tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
