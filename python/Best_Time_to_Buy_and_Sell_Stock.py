# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = sys.maxsize
        
        for cur_price in prices:
            if cur_price < min_price:
                min_price = cur_price
            elif cur_price - min_price > profit:
                profit = cur_price - min_price

        return profit