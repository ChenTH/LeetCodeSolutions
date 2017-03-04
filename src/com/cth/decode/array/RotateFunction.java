package com.cth.decode.array;

public class RotateFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
    public int maxRotateFunction(int[] A) {
        int length=A.length;
        if(length==0){
            return 0;
        }
        int[] reslut=new int[length];
        for(int i=0;i<length;i++){
        	reslut[i]=0;
        	for(int j=0;j<length;j++){
        		reslut[i]+=(j+i)%length*A[j];
        	}
        }
        int max=reslut[0];
        for(int i=1;i<length;i++){
        	if(reslut[i]>max){
        		max=reslut[i];
        	}
        }
        return max;
    }
    public int maxRotateFunction2(int[] A) {
        int length=A.length;
        if(length==0){
            return 0;
        }
        int[] reslut=new int[length];
        int sum=0;
    	for(int j=0;j<length;j++){
    		reslut[0]+=j*A[j];
    		sum+=A[j];
    	}
        int max=reslut[0];
    	for(int j=1;j<length;j++){
    		reslut[j]=reslut[j-1]+sum-length*A[length-j];
        	if(reslut[j]>max){
        		max=reslut[j];
        	}
    	}
        return max;
    }
}
