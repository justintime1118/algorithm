package leetcode;

//문제 링크: https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int i = 2;
        int prev1 = 0;
        int prev2 = 1;
        int result = 0;
        while (i <= n) {
            result = prev2 + prev1;
            prev1 = prev2;
            prev2 = result;
            i++;
        }
        return result;
    }
}