package leetcode;

import java.util.PriorityQueue;

//문제링크: https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    private class Point {
        public int[] point;
        public int distance;

        public Point(int[] point) {
            this.point = point;
            // 대소비교만 하면 되므로 제곱근 처리는 생략한다
            this.distance = point[0] * point[0] + point[1] * point[1];
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);
        for (int[] p : points)
            pq.add(new Point(p));

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++)
            ans[i] = pq.poll().point;

        return ans;
    }
}