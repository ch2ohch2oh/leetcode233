/**
 * id: 123 best time to buy and sell stock iii
 * tags: 
 * date: 2021-04-24
 * note: see discussion for a better solution and explanations
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) {
            return 0;
        }
        // two pass
        int n = prices.length;
        int [] profit1 = new int[n];
        int lowest = prices[0];
        for(int i=1; i<n; i++) {
            profit1[i] = Math.max(profit1[i-1], prices[i] - lowest);
            lowest = Math.min(prices[i], lowest);
        }
        
        int highest = prices[n-1];
        int [] profit2 = new int[n];
        for(int i=n-2; i>=0; i--) {
            profit2[i] = Math.max(profit2[i+1], highest - prices[i]);
            highest = Math.max(prices[i], highest);
        }
        
        int maxProfit = 0;
        for(int i=0; i<n; i++) {
            maxProfit = Math.max(maxProfit, profit1[i] + profit2[i]);
        }
        return maxProfit;
    }
}
