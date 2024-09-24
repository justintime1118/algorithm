package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    private static class State {
        int steps;
        int num;

        public State(int steps, int num) {
            this.steps = steps;
            this.num = num;
        }
    }

    public int solution(int x, int y, int n) {
        Queue<State> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        que.add(new State(0, x));
        while (!que.isEmpty()) {
            State state = que.poll();
            if (visited.contains(state.num) || state.num > y)
                continue;

            if (state.num == y) {
                return state.steps;
            }

            visited.add(state.num);
            que.add(new State(state.steps + 1, state.num + n));
            que.add(new State(state.steps + 1, state.num * 2));
            que.add(new State(state.steps + 1, state.num * 3));
        }

        return -1;
    }
}
/*
 * dfs로 하면 정답은 보장할 수 있으나, 재귀가 너무 깊어지면서 시간초과 발생
 * 
 * 따라서 bfs로 푼다
 * bfs도 방문처리 안하면 시간초과 발생함;;
 * 문제의 제한사항을 잘 살펴보고 시간초과도 고려하자
 */