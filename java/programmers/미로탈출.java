// https://school.programmers.co.kr/learn/courses/30/lessons/159993
// 43분 소요

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    private static class State {
        int y;
        int x;
        int steps;
        boolean lever;

        public State(int y, int x, int steps, boolean lever) {
            this.y = y;
            this.x = x;
            this.steps = steps;
            this.lever = lever;
        }
    }

    public int solution(String[] maps) {
        Queue<State> que = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        char[][] map = new char[maps.length][maps[0].length()];

        // maps를 이차원 문자 배열로 변환
        // 시작 지점을 큐에 삽입
        for (int i = 0; i < map.length; i++) {
            char[] arr = maps[i].toCharArray();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = arr[j];
                if (map[i][j] == 'S')
                    que.add(new State(i, j, 0, false));
            }
        }

        // BFS
        while (!que.isEmpty()) {
            State state = que.poll();
            int y = state.y;
            int x = state.x;
            int steps = state.steps;
            boolean lever = state.lever;

            // 맵의 범위를 벗어났거나, 벽이거나, 이미 방문한 곳이면 skip
            if (y < 0 || map.length <= y
                    || x < 0 || map[0].length <= x
                    || visited[y][x]
                    || map[y][x] == 'X')
                continue;

            // 레버를 발견하면 방문기록 및 큐 초기화, 레버 표시
            if (map[y][x] == 'L') {
                visited = new boolean[maps.length][maps[0].length()];
                que.clear();
                lever = true;
            }

            // 레버 돌렸고, 출구에 도달했으면 steps 반환
            if (state.lever && map[y][x] == 'E')
                return steps;

            visited[y][x] = true;
            // 사방으로 뻗어나감
            for (int dir = 0; dir < 4; dir++)
                que.add(new State(y + dy[dir], x + dx[dir], steps + 1, lever));
        }
        return -1;
    }
}
/*
 * BFS 활용
 * 시작지점에서 레버까지의 최소 step 수 계산
 * 레버에 도달할 수 없으면 -1 리턴
 * 그리고 다시 레버를 출발지로 해서 출구까지의 최소 step 수 계산
 * 출구에 도달할 수 없으면 -1 리턴
 */