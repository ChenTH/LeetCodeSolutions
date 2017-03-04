package com.cth.decode.math.Medium;

public class CountNumberswithUniqueDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		System.out.println(countNumbersWithUniqueDigits(2));
	}
    public static int countNumbersWithUniqueDigits(int n) {
    	int len=0;
    	if(n<10){
    		len=n+1;
    	}
    	else {
    		len=10;
		}
    	int [] result=new int[len];
    	result[0]=1;
    	for(int i=1;i<=len;i++){
    		int comb=1;
    		for (int j = 1; j < i; j++) {
				comb=comb*(10-j);
			}
    		comb*=9;
    		result[i]=comb+result[i-1];
    	}
    	if(n<10){
    		return result[n];
    	}
    	else {
    		return result[9];
		}
    }
}
