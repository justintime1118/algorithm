package programmers;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/159994

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> que2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalQue = new LinkedList<>(Arrays.asList(goal));

        while (!goalQue.isEmpty()) {
            if (!que1.isEmpty() && goalQue.peek().equals(que1.peek())) {
                que1.poll();
                goalQue.poll();
            } else if (!que2.isEmpty() && goalQue.peek().equals(que2.peek())) {
                que2.poll();
                goalQue.poll();
            } else
                break;
        }

        return goalQue.isEmpty() ? "Yes" : "No";
    }
}