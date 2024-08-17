package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 여는 괄호이면 스택에 push
            if (c == '(')
                stack.push(c);
            // 닫는 괄호이면
            else {
                // 스택이 비어있으면 안맞는 괄호쌍
                if (stack.isEmpty())
                    return false;
                // 쌍이 맞으면 스택에 있던 여는 괄호를 pop
                stack.pop();
            }
        }
        // 올바른 괄호쌍이라면 스택이 비어있어야 함
        return stack.isEmpty() ? true : false;
    }
}