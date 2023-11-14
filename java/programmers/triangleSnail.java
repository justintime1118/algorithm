package programmers;

import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        // 삼각형 그릴 이차원 배열
        int[][] grid = new int[n][n];
        
        // initGrid(grid);
        
        int i = 0;
        int j = 0;
        int num = 1;
        grid[i][j] = num;
        
        while (num < n*(n+1)/2) {
            // 아래로 이동
            while (i + 1 < n && grid[i + 1][j] == 0) {
                i++;
                num++;
                grid[i][j] = num;
            }
            // 오른쪽으로 이동하며 마킹
            while (j + 1 < n && grid[i][j + 1] == 0) {
                j++;
                num++;
                grid[i][j] = num;
            }
            // 왼쪽 위로 이동하며 마킹
            while (0 < i - 1 && 0 < j - 1 && grid[i - 1][j - 1] == 0) {
                i--;
                j--;
                num++;
                grid[i][j] = num;
            }
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
