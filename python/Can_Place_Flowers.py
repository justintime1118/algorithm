# https://leetcode.com/problems/can-place-flowers/description/

class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        ret = 0
        if len(flowerbed) == 1:
            if flowerbed[0] == 0 or n == 0:
                return True
            else:
                return False
        
        # 맨 앞 검사(직전 칸 검사 생략)
        if flowerbed[0] == 0 and flowerbed[1] == 0:
            flowerbed[0] = 1
            ret += 1

        for i in range(1, len(flowerbed) - 1):
            if flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0 and flowerbed[i] == 0 and flowerbed[i] == 0:
                flowerbed[i] = 1
                ret += 1
        
        # 맨 뒤 검사(직후 칸 검사 생략)
        if flowerbed[len(flowerbed) - 1] == 0 and flowerbed[len(flowerbed) - 2] == 0:
            ret += 1
        
        return True if n <= ret else False