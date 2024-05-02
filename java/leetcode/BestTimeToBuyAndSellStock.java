package leetcode;

//문제 링크: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;
        for (int p : prices) {
            lowest = Math.min(lowest, p);
            profit = Math.max(profit, p - lowest);
        }
        return profit;
    }
}