package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/network-delay-time/description/

class Solution {

    private class Node {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 노드번호가 1부터 시작이므로, 인덱스 번호와 맞추기 위해 n + 1로 선언
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        int[] dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) // dist[0]은 0으로 둔다
            dist[i] = Integer.MAX_VALUE;
        dist[k] = 0;

        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        pq.add(new Node(k, 0));
        while (pq.size() > 0) {
            Node cur = pq.poll();
            if (visited[cur.num])
                continue;
            visited[cur.num] = true;

            // TODO 최적화 필요할 듯
            // 인접노드 검사
            // 특정 두개의 노드 사이의 간선은 없거나 하나만 존재한다고 가정
            for (int[] adj : times) {
                // 만약 거리 갱신이 필요하면 갱신 후 해당 노드를 pq에 삽입
                if (adj[0] == cur.num && cur.distance + adj[2] < dist[adj[1]]) {
                    dist[adj[1]] = cur.distance + adj[2];
                    pq.add(new Node(adj[1], dist[adj[1]]));
                }
            }
        }

        // 닿지 않는 노드가 하나라도 있으면 -1 리턴
        for (boolean isVisited : visited) {
            if (!isVisited)
                return -1;
        }
        for (int d : dist)
            System.out.println(d);
        return Arrays.stream(dist).max().getAsInt();
    }
}
/*
 * 거리 배열 int[] d 선언 및 Integer.MAX_VALUE로 초기화
 * 방문여부 기록하는 boolean[] visited 선언 및 초기화
 * 
 * pq 생성 및 k 삽입
 * while (pq.size() > 0) {
 * pq.poll();
 * 이미 방문한 노드면 continue;
 * 방문한 노드로 표시
 * 인접 노드 거리 확인
 * 거리 갱신 필요하면 갱신하고 해당 노드들은 pq에 삽입
 * }
 * 
 * visited 중에 false인 노드가 하나라도 있으면 return -1;
 * 그렇지 않다면, return (d의 모든 원소의 합);
 */