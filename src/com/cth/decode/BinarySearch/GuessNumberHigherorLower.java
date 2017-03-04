package com.cth.decode.BinarySearch;

public class GuessNumberHigherorLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(guessNumber(1));
	}
    public static int guessNumber(int n) {
    	int begin=1;
    	int end=n;
    	while(true){
    		int middle=end+(begin-end)/2;
    		int a=guess(middle);
    		if(a==0){
    			return middle;
    		}
    		else if(a==1){
				begin=middle+1;
			}
    		else {
				end=middle-1;
			}
    	} 
    }
    public static int guess(int num) {
    	int a=1;
    	if(a<num){
    		return -1;	
    	}
    	else if(a>num){
    		return 1;	
    	}
    	else {
    		return 0;	
		}
		
	}
}
