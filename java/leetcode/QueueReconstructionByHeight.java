package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/queue-reconstruction-by-height/description/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Queue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1[0] != arr2[0])
                return arr2[0] - arr1[0];
            else
                return arr1[1] - arr2[1];
        });

        for (int[] person : people)
            pq.add(person);

        List<int[]> arrlst = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] person = pq.poll();
            arrlst.add(person[1], person);
        }

        int[][] ans = new int[people.length][2];
        for (int i = 0; i < ans.length; i++)
            ans[i] = arrlst.get(i);

        return ans;
    }
}
