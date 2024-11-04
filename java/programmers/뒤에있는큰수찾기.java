package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/154539
// 21분 소요

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int[] numbers) {
        // 인덱스를 담을 스택
        Deque<Integer> stack = new ArrayDeque<>();

        int[] ans = new int[numbers.length];

        int i = 0;
        while (i < numbers.length) {
            if (stack.isEmpty()
                    || numbers[stack.peek()] >= numbers[i])
                stack.push(i++);
            else {
                ans[stack.pop()] = numbers[i];
            }
        }

        while (!stack.isEmpty())
            ans[stack.pop()] = -1;

        return ans;
    }
}