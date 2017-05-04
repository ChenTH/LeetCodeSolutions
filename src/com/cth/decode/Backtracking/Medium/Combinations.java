package com.cth.decode.Backtracking.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args) {
		List<List<Integer>> result = combine(4, 2);
		System.out.println(result);
	}

	//
	// public static List<List<Integer>> combine(int n, int k) {
	// if (k > n) {
	// return null;
	// }
	// Integer[] integers = new Integer[n];
	// List<List<Integer>> result = new ArrayList<>();
	// for (int i = 0; i < n; i++) {
	// integers[i] = i + 1;
	// }
	// geneSubList(0, k, integers, result,0,k);
	// return result;
	// }
	//
	// public static void geneSubList(int beg, int k, Integer[] integers,
	// List<List<Integer>> result,int start ,int length) {
	// if (k == 0) {
	// List<Integer> list = new ArrayList<>();
	// for(int i=0;i<length;i++){
	// list.add(integers[start+i]);
	// }
	// result.add(list);
	// return;
	// }
	// for (int i = 0; i < integers.length-beg; i++) {
	// swap(beg, beg+i, integers);
	// geneSubList(beg + 1, k - 1, integers, result,start,length);
	// swap(i+beg, beg, integers);
	// }
	// }
	//
	// public static void swap(int i, int j, Integer[] integers) {
	// Integer temp = integers[i];
	// integers[i] = integers[j];
	// integers[j] = temp;
	// }
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		geneCombine(result, new ArrayList<>(), 1, k, n);
		return result;
	}

	public static void geneCombine(List<List<Integer>> result, List<Integer> list, int start, int k, int n) {
		if (k == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			geneCombine(result, list, i + 1, k - 1, n);
			list.remove(list.size() - 1);
		}
	}
}
