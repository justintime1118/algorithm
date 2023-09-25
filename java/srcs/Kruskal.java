// 프로그래머스 섬 연결하기 (https://programmers.co.kr/learn/courses/30/lessons/42861)

import java.util.*;

class Edge implements Comparable<Edge> {
    int x;
    int y;
    int w;

    Edge(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
    
    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

class Solution {

    int[] par;
    
    public int disjoint(int vertex) {
        if (vertex == par[vertex])
            return vertex;
        else
            return par[vertex] = disjoint(par[vertex]);
    }
    
    public int solution(int n, int[][] costs) {
        
        int ans = 0;
        
        if (n == 1)
            return ans;
        
        // 간선을 오름차순 정렬
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int[] i : costs)
            edges.add(new Edge(i[0], i[1], i[2]));
        Collections.sort(edges);
        
        // disjoint-set을 만들고 초기화
        par = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = i;
        
        // 정렬된 간선을 순회하며 같은 그룹이 아닌 정점들을 연결하는 간선만 선택
        for (Edge i : edges) {
            if (disjoint(i.x) == disjoint(i.y))
                continue ;
            par[disjoint(i.y)] = par[i.x];
            ans += i.w;
        }
        return ans;
    }
}