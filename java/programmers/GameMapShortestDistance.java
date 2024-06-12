package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private class Slot {
        int y;
        int x;
        int distance;

        public Slot(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    public int solution(int[][] maps) {
        Queue<Slot> que = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        int dstY = maps.length - 1;
        int dstX = maps[0].length - 1;

        // 동, 서, 남, 북
        int[] dirY = { 0, 0, 1, -1 };
        int[] dirX = { 1, -1, 0, 0 };

        que.add(new Slot(0, 0, 1));

        while (que.size() > 0) {
            Slot slot = que.poll();
            int y = slot.y;
            int x = slot.x;
            int distance = slot.distance;

            if (visited[y][x])
                continue;
            if (y == dstY && x == dstX)
                return distance;

            visited[y][x] = true;

            // 사방으로 퍼뜨리며 큐에 넣기
            for (int i = 0; i < 4; i++) {
                int nextY = y + dirY[i];
                int nextX = x + dirX[i];

                // 맵을 벗어나지 않으며, 막혀있지 않고, 방문한 적 없는 칸만
                if (0 <= nextY && nextY <= dstY
                        && 0 <= nextX && nextX <= dstX
                        && maps[nextY][nextX] == 1
                        && !visited[nextY][nextX])
                    que.add(new Slot(nextY, nextX, distance + 1));
            }
        }

        return -1;
    }
}

/*
 * <핵심 로직>
 * Node(좌표, 걸음 수)로 bfs 돌림
 * 현 좌표가 (n, m)가 되면 바로 return
 * 큐가 비었다면, return -1
 */