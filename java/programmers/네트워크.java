package programmers;

//문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[][] computers) {
        int ans = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // 처음 방문하는 노드이면 새로운 네트워크 갯수를 늘려주고,
            // 연결된 모든 노드들을 dfs로 방문처리하며 네트워크에 추가
            if (!visited.contains(i)) {
                ans++;
                visited.add(i);
                dfs(i, computers, visited);
            }
        }

        return ans;
    }

    public void dfs(int node, int[][] computers, Set<Integer> visited) {
        // 인접한 모든 노드에 대해 재귀적으로 dfs 계속 진행
        for (int i = 0; i < computers[node].length; i++) {
            // 연결된 노드가 아니거나, 이미 방문한 노드이면 skip
            if (computers[node][i] == 0
                    || visited.contains(i))
                continue;

            visited.add(i);
            dfs(i, computers, visited);
        }
    }
}