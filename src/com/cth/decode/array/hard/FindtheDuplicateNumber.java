package com.cth.decode.array.hard;

import java.util.HashSet;

public class FindtheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int i : nums) {
			if(set.contains(i)){
				return i;
			}
			else {
				set.add(i);
			}
		}
        return 0;
    }
    public int findDuplicate2(int[] nums) {
    	
        return 0;
    }
}
