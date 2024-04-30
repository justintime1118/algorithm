package programmers;

//문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scovilles, int k) {
        int cnt = 0;

        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int s : scovilles)
            pq.add(s);

        while (pq.peek() < k) {
            if (pq.size() < 2) {
                return -1;
            }
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
            cnt++;
        }
        return cnt;
    }
}