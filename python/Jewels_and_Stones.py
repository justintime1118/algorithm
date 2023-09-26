# https://leetcode.com/problems/jewels-and-stones/description/

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewels_set = set(jewels)
        ret = 0
        for letter in stones:
            if letter in jewels_set:
                ret += 1
        return ret