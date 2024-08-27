package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/159994

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> que1 = new LinkedList<>();
        for (String card : cards1)
            que1.add(card);
        Queue<String> que2 = new LinkedList<>();
        for (String card : cards2)
            que2.add(card);
        Queue<String> goalQue = new LinkedList<>();
        for (String word : goal)
            goalQue.add(word);

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