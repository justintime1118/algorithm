# https://leetcode.com/problems/minimum-moves-to-convert-string/

class Solution:
    def minimumMoves(self, s: str) -> int:
        result = 0
        idx = 0
        while idx < len(s):
            if s[idx] == 'X':
                idx += 3
                result += 1
            else:
                idx += 1
        return result