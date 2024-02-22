package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=java

class Solution {
    public int solution(int n) {
        int ans = n + 1;

        int targetOneCnt = countOnes(n);
        while (countOnes(ans) != targetOneCnt) {
            ans++;
        }

        return ans;
    }

    public int countOnes(int num) {
        char[] binary = Integer.toString(num, 2).toCharArray();

        int oneCnt = 0;
        for (char c : binary) {
            if (c == '1')
                oneCnt++;
        }

        return oneCnt;
    }
}