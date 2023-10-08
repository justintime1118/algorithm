# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
# 주가 변화 추이를 그래프로 그려서 시각화 해보면 풀이를 쉽게 떠올릴 수 있다 (기술통계학, descriptive statistics)
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