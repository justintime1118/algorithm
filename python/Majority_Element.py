# https://leetcode.com/problems/majority-element/
# 시간복잡도 측면에서 점수가 낮음. 단, 메모리 절약은 좋음.

from collections import Counter

class Solution:
    # 나의 풀이
    def majorityElement(self, nums: List[int]) -> int:
        counter = Counter()
        half = len(nums)//2 + 1
        for num in nums:
            counter[num] += 1
            if counter[num] >= half:
                return num
    
    '''
    # 다이나믹 프로그래밍
    def majorityElement(self, nums: List[int]) -> int:
        counts = collections
        for num in nums:
            if counts[num] == 0:
                counts[num] = nums.count(num)

            if counts[num] > len(nums) // 2:
                return num
    '''

    '''
    # 분할정복
    def majorityElement(self, nums: List[int]) -> int:
        if not nums: # base condition 1
            return None
        if len(nums) == 1: # base condition 2
            return nums[0]
        
        half = len(nums) // 2
        a = self.majorityElement(nums[:half])
        b = self.majorityElement(nums[half:])

        return [b, a][nums.count(a) > half]
    '''


    '''
    # 정렬하여 가운데 지정. 파이썬다운 방식(맨 처음 이 풀이를 떠올렸다가, 경솔하게 안될 거라 생각하고 넘어갔었음.)
    def majorityElement(self, nums: List[int]) -> int:
        return sorted(nums)[len(nums) // 2]
    '''