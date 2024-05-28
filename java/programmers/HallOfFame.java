package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/138477

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] scores) {
        int[] ans = new int[scores.length];

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scores.length; i++) {
            pq.add(scores[i]);
            if (pq.size() > k)
                pq.poll();
            ans[i] = pq.peek();
        }

        return ans;
    }
}