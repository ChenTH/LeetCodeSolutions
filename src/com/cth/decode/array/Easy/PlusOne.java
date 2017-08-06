package com.cth.decode.array.Easy;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={9,9};
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
		System.out.println();
		int[] b=plusOne(a);
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]);
		}
	}
    public static int[] plusOne(int[] digits) {
    	int carry=1;
    	int i=digits.length-1;
    	for(i=digits.length-1;i>=0;i--){
    		if(digits[i]==9){
    			digits[i]=0;
    		}
    		else{
    			digits[i]=digits[i]+1;
    			carry=0;
    			break;
    		}
    	}
    	
    	if(i==-1&&carry==1){
    		int[] b=new int[digits.length+1];
    		b[0]=1;
    		for(int j=0;j<digits.length;j++){
    			b[j+1]=digits[j];
    		}
    		return b;	
    	}
    	else {
    		return digits;	
		}
    }
}
