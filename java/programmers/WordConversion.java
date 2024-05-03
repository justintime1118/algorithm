package programmers;

//문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public class State {
        String word;
        int cnt;

        public State(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    public boolean isChangeable(String src, String dst) {
        char[] from = src.toCharArray();
        char[] to = dst.toCharArray();

        int diff = 0;
        for (int i = 0; i < from.length; i++) {
            if (from[i] != to[i])
                diff++;
        }
        return diff == 1 ? true : false;
    }

    public int solution(String begin, String target, String[] words) {
        // 얘를 만들어서 방문처리를 해주면 되는건데,
        // 괜히 set에 담아서 처리하려다가 고생함.
        // set으로 만든 for문 내에서 set.remove()를 호출해서 ConcurrentModificationException 발생
        boolean[] visited = new boolean[words.length];

        Queue<State> que = new LinkedList<>();
        que.add(new State(begin, 0));
        while (!que.isEmpty()) {
            State cur = que.poll();

            // 최종 결과물에 도달했으면 걸린 단계수를 return
            if (cur.word.equals(target))
                return cur.cnt;

            for (int i = 0; i < words.length; i++) {
                // 이미 사용한 단어이면 skip
                if (visited[i])
                    continue;
                // 현재 단어에서 변환 가능한 단어이면 큐에 넣어주고, 방문처리
                if (isChangeable(cur.word, words[i])) {
                    que.add(new State(words[i], cur.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
}
/*
 * 무조건 words에 있는 어떤 한단어로 바꾸는 것으로 시작된다.
 * 현재 상태에서 한단어 차이나는 녀석들을 골라서 전부 큐에 넣기(이때 현재 몇단계인지를 같이 넣어줘야겠다)
 * 그 다음에 또 큐에 넣기
 * 완성되자마자 몇단계 거쳤는지를 딱 리턴
 */
