package com.cth.decode.array.Medium;

import com.cth.decode.array.Medium.RandomizedSet;

public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet set=new RandomizedSet();
		System.out.println(set.insert(-1));
		System.out.println(set.remove(-1));
		System.out.println(set.insert(-2));
		System.out.println(set.getRandom());
		System.out.println(set.remove(-1));
		System.out.println(set.insert(-2));
		System.out.println(set.getRandom());
	}
}

