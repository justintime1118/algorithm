package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        // 회전하기 편하게 문자열을 ArrayDeque에 담음
        Deque<Character> src = new ArrayDeque<>();
        for (char c : s.toCharArray())
            src.add(c);

        int ans = 0;
        // 0~s의 길이만큼 회전하며 올바른 괄호 문자열인지 확인
        for (int i = 0; i < src.size(); i++) {
            if (isMatchingBracket(src))
                ans++; // 올바른 괄호 문자열이면 카운트
            src.add(src.pop()); // 회전
        }

        return ans;
    }

    public boolean isMatchingBracket(Deque<Character> src) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchedBrackets = new HashMap<>();
        matchedBrackets.put(']', '[');
        matchedBrackets.put('}', '{');
        matchedBrackets.put(')', '(');

        for (Character c : src) {
            // 여는 괄호이면 스택에 Push
            if (!matchedBrackets.containsKey(c))
                stack.push(c);
            // 닫는 괄호이면 상쇄되는지 확인
            else {
                if (stack.isEmpty() || stack.peek() != matchedBrackets.get(c))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}