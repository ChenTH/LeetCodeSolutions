package com.cth.test;

public class AssertTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		for(i=0;i<5;i++)
		{
			System.out.println(i);
		}
		//�������С�Ķ���һ��--i;
//		--i;
		assert i==5;		
	}

}

