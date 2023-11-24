import java.util.*;

class Dijkstra {
    
    public class Edge implements Comparable<Edge> {
        int v, w;
        
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.w - edge.w;
        }
    }
    
    public boolean visitedAll(int[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0)
                return false;
        }
        return true;
    }
    
    public int solution(int N, int[][] road, int K) {
        int ans = 0;
        int[] visited = new int[N + 1];
        
        int[] dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            dist[i] = 10000 * N;

        int[][] graph = new int[N + 1][N + 1];
        for (int[] i : road) {
            if (graph[i[0]][i[1]] != 0 && graph[i[0]][i[1]] < i[2])
                continue ;
            graph[i[0]][i[1]] = graph[i[1]][i[0]] = i[2];
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        Edge edge = new Edge(1, 0);
        pq.add(edge);
        dist[1] = 0;
        int cur;
        
        while (visitedAll(visited) == false) {
            edge = pq.poll();
            // 이미 방문한 정점일 경우 밑에 작업을 또 하지 않고 바로 그 다음 원소를 poll 하는 아래 두줄의 코드가 없어서 메모리 및 시간 초과가 났음
            while (visited[edge.v] == 1)
                edge = pq.poll();
            cur = edge.v;
			visited[cur] = 1;
            for (int v = 1; v < N + 1; v++) {
                if (graph[cur][v] == 0)
                    continue ;
                if (dist[v] > dist[cur] + graph[cur][v])
                    dist[v] = dist[cur] + graph[cur][v];
                // 여기서 동일한 참조변수 edge를 안에 값만 바꿔서 재활용하며 pq.add의 인자로 넘겼는데, 이게 문제였음
                // pq는 객체를 복사해서 넣지않고 참조변수의 값만 그대로 가져오기 때문에 계속 생각과 다르게 동작을 했던 것
                if (visited[v] == 0)
                    pq.add(new Edge(v, dist[v]));
            }
        }
        for (int i = 1; i < N + 1; i++) {
                if (dist[i] <= K)
                    ans++;
        }
        return ans;
    }
}
