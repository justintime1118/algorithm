package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : nums)
            pq.add(num);

        for (int i = 0; i < k - 1; i++)
            pq.poll();

        return pq.poll();
    }
}