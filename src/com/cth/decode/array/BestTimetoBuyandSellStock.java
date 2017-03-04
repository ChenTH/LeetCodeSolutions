package com.cth.decode.array;

public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={7, 1, 5, 3, 6, 4};
		int b=maxProfit(a);
		System.out.println(b);
	}
    public static int maxProfit(int[] prices) {
    	int target=0;
    	if(prices.length==0){
    		return target;
    	}
    	int a=prices[0];
    	for(int i=1;i<prices.length;i++){
    		if(prices[i]>a){
    			if(prices[i]-a>target){
        			target=prices[i]-a;
    			}
    		}
    		else {
    			a=prices[i];
			}
    	}
		return target;
     
    }
}
