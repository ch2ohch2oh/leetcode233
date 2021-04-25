/**
 * id: 121 best time to buy and sell stock
 * tags: array
 * date: 2021-04-24
 */
class Solution {
    public int maxProfit(int[] prices) {
        // For each day, we want to know the lowest price 
        // before that day
        if(prices.length <= 1) {
            return 0;
        }
        int lowest = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }
        return maxProfit;
    }
}
