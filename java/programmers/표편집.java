package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/81303

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(int n, int k, String[] commands) {
        int cursor = k;
        boolean[] isDeleted = new boolean[n];
        Deque<Integer> deletedCells = new ArrayDeque<>();

        for (String cmd : commands) {
            char c = cmd.charAt(0);
            // 커서 이동
            if (c == 'U') {
                int targetSteps = cmd.charAt(2);
                int currentSteps = 0;
                while (currentSteps < targetSteps) {
                    cursor++;
                    if (isDeleted[cursor] == false)
                        currentSteps++;
                }
            } else if (c == 'D') {
                int targetSteps = cmd.charAt(2);
                int currentSteps = 0;
                while (currentSteps < targetSteps) {
                    cursor--;
                    if (isDeleted[cursor] == false)
                        currentSteps++;
                }
            }
            // 행 삭제
            else if (c == 'C') {
                isDeleted[cursor] = true;
                deletedCells.push(cursor);
                // 최초의 true가 나올때까지 아래로 쭉 내리면서 다음 행으로 cursor 이동
                while (cursor < n && isDeleted[cursor] == true)
                    cursor++;
                // 만약 맨 아래까지 갔는데도 true가 없으면
                // 위로 가면서 최초의 true 찾아서 cursor 이동
                if (cursor == n) {
                    cursor = deletedCells.peek();
                    while (isDeleted[cursor] == true)
                        cursor--;
                }
            }
            // 행 복구
            else {
                isDeleted[deletedCells.pop()] = false;
            }
        }

        // 정답 반환
        StringBuilder sb = new StringBuilder(n);
        for (boolean isDel : isDeleted)
            sb.append(isDel ? 'X' : 'O');

        return sb.toString();
    }
}
/*
 * <요구사항 정리>
 * 한번에 한 행만 선택 가능(단, 표의 범위를 벗어날 수 없음)
 * 명령어 종류
 * - U X: move up by X cells
 * - D X: move down by X cells
 * - C: delete
 * - Z: undo. 단, 현재 선택한 행번호는 바뀌지 않음
 * 최종적으로 각 행이 삭제됐는지 여부를 순서에 맞게 문자열로 표현하여 반환
 */

/*
 * <로직>
 * [자료구조 초기화]
 * 현재 행번호를 기록한 cursor 변수 마련
 * 전체 행의 삭제여부를 기록하는 boolean[] isDeleted 선언
 * 삭제된 행번호를 스택으로 보관할 ArrayDeque deletedCells 선언
 * 
 * [cmd 순회]
 * move
 * - isDeleted에서 false인 애들만 유효하게 카운트하며 커서 이동
 * delete
 * - isDeleted 값을 true으로 바꿔주고 deletedCells에 행번호를 push
 * - 최초의 true가 나올때까지 아래로 쭉 내리면서 다음 행으로 cursor 이동
 * - 만약 맨 아래까지 갔는데도 true가 없으면 stack.peek() 행번호 에서부터 위로 가면서 최초의 true 찾아서 cursor
 * 이동
 * - 여기가 효율성에서 문제 있다!!!!!
 * undo
 * - stack에서 pop한 행번호를 isDeleted에 false로 반영
 * 
 * [정답 반환]
 * isAlive를 순회하며, true false에 따라 StringBuilder에 적절히 append
 */