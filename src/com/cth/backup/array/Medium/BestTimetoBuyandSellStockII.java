package com.cth.backup.array.Medium;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxProfit(int[] prices) {
        int Profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                Profit += prices[i + 1] - prices[i];
            }
        }
        return Profit;
    }
}
