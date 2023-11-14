package programmers;

import java.util.*;

class Solution {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        
        // 삼각형 그릴 이차원 배열
        int[][] grid = new int[n][n];
        
        int i = 0;
        int j = 0;
        int num = 1;
        int dir = 0;
        grid[i][j] = num;
        while (num < n*(n+1)/2) {
            
            while (i + dy[dir] < n && j + dx[dir] < n && grid[i + dy[dir]][j + dx[dir]] == 0) {
                i += dy[dir];
                j += dx[dir];
                num++;
                grid[i][j] = num;                
            }
            dir++;
            dir %= 3;
        }
        
        // printGrid(grid);

        List<Integer> ans = new ArrayList<>();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != 0)
                    ans.add(grid[r][c]);
            }
        }
        return ans.stream().mapToInt(x->x).toArray();
    }
    
    // private void printGrid(int[][] grid) {
    //     for (int[] arr : grid) {
    //         for (int num : arr)
    //             System.out.print(num);
    //         System.out.println("");
    //     }
    // }
}
