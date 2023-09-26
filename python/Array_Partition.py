# https://leetcode.com/problems/array-partition/description/

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])