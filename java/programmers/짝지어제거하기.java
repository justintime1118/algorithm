package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c)
                stack.push(c);
            else
                stack.pop();
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
