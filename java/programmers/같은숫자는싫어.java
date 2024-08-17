package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int n : arr) {
            if (stack.isEmpty() || stack.peek() != n)
                stack.push(n);
        }

        int[] ans = new int[stack.size()];
        for (int i = 1; i <= ans.length; i++)
            ans[ans.length - i] = stack.pop();
        return ans;
    }
}