package programmers;

//문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            cnt++;
            dfs(i, computers, n);
        }

        return cnt;
    }

    public void dfs(int cur, int[][] computers, int n) {
        visited[cur] = true;
        for (int i = 0; i < n; i++) {
            if (computers[cur][i] == 1 && visited[i] == false)
                dfs(i, computers, n);
        }
    }
}
/*
 * 이차원 배열이 나타내는 연결의 모습이 첨에 생각한 것과 다른데,
 * 집중력이 저하되기도 하고,
 * 앞에 문제 잘 풀렸고 DFS로 푸는 문제인걸 딱 아니까 방심하고 문제 대충 풀었음
 */