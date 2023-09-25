// 프로그래머스 섬 연결하기 (https://programmers.co.kr/learn/courses/30/lessons/42861)

import java.util.*;

class Solution {

    public int solution(int n, int[][] costs) {
        int ans = 0;
        // 방문한 정점 정보를 담는 배열
        int visited[] = new int[n];
        // 주어진 그래프의 정보를 담는 2차원 배열
        int graph[][] = new int[n][n];
        for (int[] xy : costs) {
            graph[xy[0]][xy[1]] = xy[2];
            graph[xy[1]][xy[0]] = xy[2];
        }
        // 해당 시점에 MST가 가진 간선들을 저장할 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[1] - arr2[1];
            }
        });
        
        // 프림 알고리즘 메인 로직 시작부
        int s = costs[0][0];
        int[] tmp;
        for (int i = 0; i < n - 1; i++) {
            visited[s] = 1;
            for (int j = 0; j < n; j++) {
                tmp = new int[2];
                tmp[0] = j;
                tmp[1] = graph[s][j];
                pq.add(tmp);
            }
            // 아래 조건을 위쪽(pq.add 전)에 걸어뒀다가 한참 고생했음
            while (visited[pq.peek()[0]] == 1 || pq.peek()[1] == 0)
                pq.poll();
            s = pq.peek()[0];
            ans += pq.peek()[1];
            pq.poll();
        }
        return ans;
    }
}