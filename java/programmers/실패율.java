package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;

class Solution {
    class Stage {
        int stageNum;
        int totalCnt; // 도달한 전체 인원수
        int clearCnt; // 클리어한 인원수

        public double getFailureRatio() {
            if (this.totalCnt == 0)
                return 0;
            int unclearCnt = totalCnt - clearCnt;
            return (double) unclearCnt / (double) this.totalCnt;
        }

        public Stage(int stageNum, int totalCnt, int clearCnt) {
            this.stageNum = stageNum;
            this.totalCnt = totalCnt;
            this.clearCnt = clearCnt;
        }
    }

    public int[] solution(int N, int[] stages) {
        Stage[] status = new Stage[N + 1];
        for (int i = 1; i <= N; i++)
            status[i] = new Stage(i, 0, 0);

        // stages를 순회하며 스테이지 별 도달인원과 클리어인원을 업데이트
        for (int stageNum : stages) {
            for (int i = 1; i < stageNum; i++) {
                status[i].totalCnt++;
                status[i].clearCnt++;
            }
            if (stageNum != N + 1)
                status[stageNum].totalCnt++;
        }

        /*
         * 실패율에 따라 내림차순으로 스테이지 번호를 정렬
         * - 실패율이 같으면 작은 번호의 스테이지가 먼저 오도록함
         */
        Stage[] trimmedStatus = Arrays.copyOfRange(status, 1, N + 1);
        Arrays.sort(trimmedStatus,
                (s1, s2) -> {
                    if (Double.compare(s2.getFailureRatio(), s1.getFailureRatio()) != 0)
                        return Double.compare(s2.getFailureRatio(), s1.getFailureRatio());
                    else
                        return s1.stageNum - s2.stageNum;
                });
        int[] ans = new int[N];
        for (int i = 0; i < N; i++)
            ans[i] = trimmedStatus[i].stageNum;

        return ans;
    }
}