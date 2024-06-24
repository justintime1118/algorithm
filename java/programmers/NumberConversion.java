package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] { x, 0 });

        Set<Integer> visited = new HashSet<>();

        while (que.size() > 0) {
            int[] elem = que.poll();
            int val = elem[0];
            int steps = elem[1];

            if (val == y)
                return steps;

            if (visited.contains(val))
                continue;
            visited.add(val);

            if (val + n <= y)
                que.add(new int[] { val + n, steps + 1 });
            if (val * 2 <= y)
                que.add(new int[] { val * 2, steps + 1 });
            if (val * 3 <= y)
                que.add(new int[] { val * 3, steps + 1 });
        }
        return -1;
    }
}
/*
 * <핵심 아이디어>
 * 완전탐색을 하면서 최소 횟수를 구하기엔 bfs가 적절해 보인다
 */