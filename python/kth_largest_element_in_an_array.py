# https://leetcode.com/problems/kth-largest-element-in-an-array/

import heapq

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # heapify(nums) # 리스트를 최소 heap으로 바꿈. (인자로 넣은 리스트 자체를 직접 변환)
        
        # heap 정렬을 이용하여 nums 배열에서 k개의 가장 큰 원소를 추출하여 리스트로 return
        return nlargest(k, nums)[-1]