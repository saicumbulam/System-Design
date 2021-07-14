package Greedy;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            buy =  Math.min(buy, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }

        return maxProfit;
    }
}
