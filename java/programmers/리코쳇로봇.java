
//https://school.programmers.co.kr/learn/courses/30/lessons/169199

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static class State {
        int row;
        int col;
        int steps;

        public State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    int[][] dirs = {
            { -1, 0 }, // 상
            { 1, 0 }, // 하
            { 0, -1 }, // 좌
            { 0, 1 } // 우
    };

    public int solution(String[] board) {
        Queue<State> que = new LinkedList<>();

        // 이차원 배열에 board를 옮겨 담으면서 로봇의 초기 위치를 큐에 첫번째 원소로 추가
        char[][] grid = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            char[] rowArr = board[i].toCharArray();
            for (int j = 0; j < rowArr.length; j++) {
                grid[i][j] = rowArr[j];
                if (rowArr[j] == 'R')
                    que.add(new State(i, j, 0));
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while (!que.isEmpty()) {
            State cur = que.poll();
            int row = cur.row;
            int col = cur.col;
            int steps = cur.steps;

            if (grid[row][col] == 'G')
                return steps;

            if (visited[row][col])
                continue;

            visited[row][col] = true;

            // 사방으로 이차원 배열의 경계값 또는 'D'를 만날때까지 계속 이동한뒤 큐에 담음
            // (배열 범위를 벗어나지 않도록 한다)
            for (int[] dir : dirs) {
                que.add(slide(row, col, steps, dir, grid));
            }
        }
        return -1;
    }

    public State slide(int row, int col, int steps, int[] dir, char[][] grid) {
        while (0 <= row + dir[0] && row + dir[0] < grid.length
                && 0 <= col + dir[1] && col + dir[1] < grid[0].length
                && grid[row + dir[0]][col + dir[1]] != 'D') {
            row += dir[0];
            col += dir[1];
        }
        return new State(row, col, steps + 1);
    }
}