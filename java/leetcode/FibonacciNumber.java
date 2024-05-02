package leetcode;

//문제 링크: https://leetcode.com/problems/fibonacci-number/

class Solution {
    int[] dp;

    public int fib(int n) {
        dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;

        return recur(n);
    }

    public int recur(int n) {
        if (n < 2 || dp[n] != 0)
            return dp[n];
        dp[n] = recur(n - 1) + recur(n - 2);
        return dp[n];
    }
}