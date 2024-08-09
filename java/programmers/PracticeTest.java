package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        // 채점 결과로 쓸 배열 선언
        int[] scores = new int[3];

        // 찍는 방식에 따라 세명을 채점
        // 찍는 방식 패턴
        int[] PATTERN_1 = { 1, 2, 3, 4, 5 };
        int[] PATTERN_2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] PATTERN_3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        // 정답지와 비교하며 채점 결과 배열의 값을 갱신
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == PATTERN_1[i % 5])
                scores[0]++;
            if (answers[i] == PATTERN_2[i % 8])
                scores[1]++;
            if (answers[i] == PATTERN_3[i % 10])
                scores[2]++;
        }

        // 최고점수 구해서 오름차순으로 최고득점자 리턴
        List<Integer> ans = new ArrayList<>();
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore)
                ans.add(i + 1);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}