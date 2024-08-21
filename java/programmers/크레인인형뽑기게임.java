package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // board 번호 별로 스택을 만들어서 인형을 채워둔다
        // 크레인은 항상 가장 위에있는 인형(top)에 접근하게 되므로 stack 채택
        Map<Integer, Deque<Integer>> boardMap = new HashMap<>();
        for (int i = 1; i <= board.length; i++) {
            boardMap.put(i, new ArrayDeque<>());
            for (int j = 0; j < board.length; j++) {
                // 0은 인형이 없다는 뜻이므로 skip
                // moves에 들어가는 격자 위치는 1부터 시작하지만,
                // 배열 인덱스는 0부터 시작이므로 i - 1로 처리해줌
                if (board[j][i - 1] == 0)
                    continue;
                boardMap.get(i).add(board[j][i - 1]);
            }
        }

        // 별도의 바구니 스택 생성
        Deque<Integer> basket = new ArrayDeque<>();

        // moves를 순회하면서 바구니에 넣음
        // top과 같은 것을 집으면 Pop하면서 갯수 센다(한번에 두개씩 사라짐)
        int ans = 0;
        for (int move : moves) {
            // 비어있는 위치에 접근하면 아무일도 일어나지 않음
            if (boardMap.get(move).isEmpty())
                continue;
            // 바구니가 비어있거나 or 서로 다른 인형이면 바구니에 들어감
            if (basket.isEmpty()
                    || !basket.peek().equals(boardMap.get(move).peek())) {
                basket.push(boardMap.get(move).pop());
            }
            // 같은 인형이면 둘 다 사라짐
            else {
                boardMap.get(move).pop();
                basket.pop();
                ans += 2;
            }
        }
        return ans;
    }
}