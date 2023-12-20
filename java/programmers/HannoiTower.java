package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.*;

class Solution {
    
    private ArrayList<int[]> orders = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        move(n, 1, 3);
        
        int[][] ans = new int[orders.size()][2];
        for (int i = 0; i < orders.size(); i++) {
            ans[i] = orders.get(i);
        }
        return ans;
    }
    
    public void move(int n, int from, int to) {
        
        if (n == 1) {
            // 1을 from에서 to로 옮긴다
            orders.add(new int[] {from, to});
            return;
        }
        
        move(n - 1, from, 6 - from - to);
        // 원판 n을 옮긴다
        orders.add(new int[] {from, to});
        move(n - 1, 6 - from - to, to);
    }
}