package com.cth.decode.DynamicProgramming.Medium;

public class CoinChange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    //	public static int  solution(int[] coins,int amount,int size,int idx) {
//		if(size<0){
//			return amount+1;
//		}
//		if(size==0){
//			return 0;
//		}
//		if(idx>=coins.length){
//			return amount+1;
//		}
//		
//		return Math.min(solution(coins, amount, size-coins[idx], idx)+1, solution(coins, amount, size, idx+1));
//	}
//    public static int coinChange(int[] coins, int amount) {
//    	int result=solution(coins, amount, amount,0);
//        return result==amount+1?-1:result;
//    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
