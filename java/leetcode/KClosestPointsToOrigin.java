package leetcode;

import java.util.Arrays;

//문제링크: https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> {
            return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
        });

        return Arrays.copyOfRange(points, 0, k);
    }
}