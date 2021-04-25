/**
 * id: 122 best time to buy and sell stock ii
 * tags: array
 * date: 2021-04-24
 * note: also look at this short solution
 *       https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/39420/Three-lines-in-C%2B%2B-with-explanation
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) {
            return 0;
        }
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else if(i == prices.length - 1) {
                profit += prices[i] - buy;
            } else if(prices[i + 1] < prices[i]) {
                profit += prices[i] - buy;
                buy = prices[i + 1];
            }
        }
        return profit;
    }
}