package leetcode;

//문제 링크: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int diff = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            diff = prices[i + 1] - prices[i];
            profit += 0 < diff ? diff : 0;
        }
        return profit;
    }
}