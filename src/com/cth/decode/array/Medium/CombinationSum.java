package com.cth.decode.array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,3,6,7};
		combinationSum(a,7);
	}
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> result=new ArrayList<>();
    	backTracking(candidates,result,new ArrayList<>(),target,0);
    	return result;
    }
    public static void backTracking(int[] candidates,List<List<Integer>> result,List<Integer> list,int target,int i){
    	if(target==0){
    		List<Integer> res=new ArrayList<>(list);
    		result.add(res);
    	}
    	else {
			for(int j=i;j<candidates.length && candidates[j]<=target;j++){
				System.out.println(j);
				list.add(candidates[j]);
				backTracking(candidates, result, list, target-candidates[j], j);
				list.remove(list.size()-1);
			}
		}
    }
}
