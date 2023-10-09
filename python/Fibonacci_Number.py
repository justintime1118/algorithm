# https://leetcode.com/problems/fibonacci-number/
# 처음에 단순히 수열을 구하는 방식으로 풀었지만, 책의 '두 변수만 이용해 공간 절약'이라는 문구를 보고 코드를 보다 최적화함

class Solution:
    def fib(self, n: int) -> int:
        # if n == 0 or n == 1:
        #     return n
        a, b = 0, 1
        for _ in range(n):
            a, b = b, a + b
        return a
    '''
    def fib(self, n: int) -> int:
        seq = [0 for _ in range(31)]
        seq[0] = 0
        seq[1] = 1
        if n <= 1:
            return seq[n]
        
        i = 2
        while i <= n:
            seq[i] = seq[i - 1] + seq[i - 2]
            i += 1
        
        return seq[n]
    '''