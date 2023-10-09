# https://leetcode.com/problems/maximum-score-from-removing-stones/

class Solution:
    def maximumScore(self, a: int, b: int, c: int) -> int:
        piles = [a, b, c]
        score = 0
        piles.sort(reverse = True)
        while piles[0] > 0 and piles[1] > 0:
            piles[0] -= 1
            piles[1] -= 1
            piles.sort(reverse = True)
            score += 1
        return score