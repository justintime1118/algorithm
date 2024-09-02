package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0;
        while (i < prices.length) {
            // 스택이 비어있거나, 가격이 떨어지지 않은 경우 push하고 다음 가격으로 넘어감
            if (stack.isEmpty() || prices[stack.peek()] <= prices[i]) {
                stack.push(i);
                i++;
            }
            // 가격이 떨어진 경우,
            // pop한 인덱스의 가격 떨어지지 않은 기간 기록
            // 다음 가격으로 안넘어감(현재 가격과 스택의 top을 다시 비교하도록 함)
            else {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
        }

        // 가격이 한번도 떨어지지 않아서 스택에 남아있는 녀석들 처리
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = prices.length - 1 - idx;
        }

        return ans;
    }
}