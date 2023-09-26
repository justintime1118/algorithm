# https://leetcode.com/problems/two-sum/description/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx, num in enumerate(nums):
            try:
                pos = nums.index(target - num, idx + 1, len(nums))
            except Exception:
                continue
            else:
                return [idx, pos]