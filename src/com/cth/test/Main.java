package com.cth.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
		final String[] rtList = in.nextLine().split(",");
		final int requestNum = Integer.valueOf(in.nextLine());
		final int threadNum = Integer.valueOf(in.nextLine());
		System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
	}
	/**
	 * ���ʹ�����ŵ�������������ؾ����㷨����������ģ�Ͷ���ܹ��������������󣬵�λ���롣
	 * @return
	 */
	static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
		//TODO
		int count=rtList.length;
		int[] brokerThreadNum = new int[count];
		while(requestNum>0){
//			for(int i=0;i< )
		}
		return 0;
	}
}
