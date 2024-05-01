package leetcode;

//문제 링크: https://leetcode.com/problems/number-of-islands/description/

class Solution {
    // 동, 서, 남, 북
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        int ans = 0;
        for (int col = 0; col < grid.length; col++) {
            for (int row = 0; row < grid[0].length; row++) {
                if (!visited[col][row] && grid[col][row] == '1') {
                    ans++;
                    markIsland(col, row, grid);
                }
            }
        }

        return ans;
    }

    public void markIsland(int col, int row, char[][] grid) {
        if (!(0 <= col && col < grid.length)
                || !(0 <= row && row < grid[0].length)
                || grid[col][row] == '0'
                || visited[col][row])
            return;

        visited[col][row] = true;
        for (int dir = 0; dir < 4; dir++) {
            markIsland(col + dy[dir], row + dx[dir], grid);
        }
    }
}
