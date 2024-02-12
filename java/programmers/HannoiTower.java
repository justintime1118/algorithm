package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12946
import java.util.ArrayList;

class Solution {

    ArrayList<int[]> moveHistory = new ArrayList<>();

    public int[][] solution(int n) {

        move(n, 1, 3);

        return moveHistory.stream().toArray(int[][]::new);
    }

    public void move(int plateNum, int currentPos, int nextPos) {

        if (plateNum == 1) {
            moveHistory.add(new int[] { currentPos, nextPos });
            return;
        }
        move(plateNum - 1, currentPos, 6 - currentPos - nextPos);
        moveHistory.add(new int[] { currentPos, nextPos });
        move(plateNum - 1, 6 - currentPos - nextPos, nextPos);
    }
}