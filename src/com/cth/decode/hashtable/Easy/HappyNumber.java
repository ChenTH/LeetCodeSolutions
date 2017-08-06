package com.cth.decode.hashtable.Easy;

import java.util.ArrayList;
import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a= isHappy(19);
		System.out.println(a);
	}
    public static boolean isHappy(int n) {
    	HashSet<Integer> set=new HashSet<>();
    	while(n!=1){
        	ArrayList<Integer> arrayList=new ArrayList<>();
    		set.add(n);
    		while(n!=0){
    	    	  arrayList.add(n%10);
    	    	  n=n/10;
    	    	}
    	    	int m=0;
    	    	for(int i=0;i<arrayList.size();i++){
    	    		m=m+arrayList.get(i)*arrayList.get(i);
    	    	}
    	    	if(set.contains(m)){
    	    		return false;
    	    	}
    	    	n=m;
    	}
		return true;
    }

}
