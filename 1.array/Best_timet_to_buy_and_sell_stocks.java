public class Best_timet_to_buy_and_sell_stocks {
    
}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        // Start by assuming we buy on the first day
        int buyP = prices[0];

        // Variable to keep track of the maximum profit so far
        int maxP = 0;

        // Traverse prices from day 1 (since day 0 is already assumed as buyP)
        for (int i = 1; i < prices.length; i++) {

            // If the current day's price is smaller than our previous buy price,
            // update the buy price (buy at cheaper rate)
            if (prices[i] < buyP) {
                buyP = prices[i];
            }

            // Otherwise, calculate profit if we sell today,
            // and update max profit if this is better
            maxP = Math.max(maxP, prices[i] - buyP);
        }

        // Return the maximum profit found
        return maxP;
    }
}
