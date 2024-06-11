package leetcode;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    private class Node {
        int num;
        int price;
        int stop;

        public Node(int num, int price, int stop) {
            this.num = num;
            this.price = price;
            this.stop = stop;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new HashMap<>());
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.price - n2.price);
        pq.add(new Node(src, 0, 0));

        Map<Integer, Integer> visited = new HashMap<>();

        while (pq.size() > 0) {
            Node node = pq.poll();

            // dst에 도달했으면 바로 return
            if (node.num == dst)
                return node.price;

            // 경유지를 k개까지 사용한 상태 or 인접한 노드가 없으면 스킵
            if (node.stop == k + 1 || !graph.containsKey(node.num))
                continue;

            // 방문 표시
            visited.put(node.num, node.stop);

            // 인접노드 검사
            for (Map.Entry<Integer, Integer> adj : graph.get(node.num).entrySet()) {
                // 방문한적 없는 노드 or 더 적은 stop으로 재방문이면 pq에 추가
                if (!visited.containsKey(adj.getKey()) || node.stop < visited.get(adj.getKey()))
                    pq.add(new Node(adj.getKey(), node.price + adj.getValue(), node.stop + 1));
            }
        }

        return -1;
    }
}
/*
 * 다익스트라로 돌면서 dst에 딱 도달하면 바로 해당 price return
 * 도달 못하면 return -1
 * 
 * 유의사항
 * - k번을 초과해서 stop을 썼으면 더 이상의 진행은 막아줘야 함
 * - 이미 방문한 노드라 할지라도 이전에 방문했을 때보다 더 적은 stop으로 다시 온 것이라면 pq에 또 넣어줘야 정답이 보장됨
 */