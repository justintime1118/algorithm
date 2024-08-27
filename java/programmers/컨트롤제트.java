package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/120853

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] split = s.split(" ");
        for (String str : split) {
            if (str.equals("Z"))
                stack.pop();
            else
                stack.push(Integer.valueOf(str));
        }
        return stack.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}