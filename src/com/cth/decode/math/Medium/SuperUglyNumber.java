package com.cth.decode.math.Medium;

public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,3,5};
		nthSuperUglyNumber(3,a);
	}
	public static int nthSuperUglyNumber(int n, int[] primes) {
    	int [] k=new int [n];
    	int [] p=new int[primes.length];
    	k[0]=1;
    	for (int i = 1; i < n; i++) {
    		k[i]=Integer.MAX_VALUE;
    		for(int j=0;j<primes.length;j++){
    			long temp=k[p[j]]*primes[j];
    			if(temp<k[i]){
    				k[i]=(int) temp;
    			}
    		}
    		for(int j=0;j<primes.length;j++){
    			long temp=k[p[j]]*primes[j];
    			if(temp==k[i]){
    				p[j]++;
    			}
    		}
		}
		return k[n-1];
    }
}
