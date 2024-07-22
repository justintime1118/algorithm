package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/queue-reconstruction-by-height/description/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        for (int[] person : people)
            pq.add(person);

        List<int[]> arrlst = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            arrlst.add(person[1], person);
        }

        return arrlst.toArray(new int[people.length][2]);
    }
}