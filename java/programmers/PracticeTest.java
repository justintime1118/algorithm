package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int maxScore = 0;
        
        int[] submission1 = {1, 2, 3, 4, 5};
        int score1 = checkScore(answers, submission1);
        maxScore = Math.max(maxScore, score1);
        
        int[] submission2 =  {2, 1, 2, 3, 2, 4, 2, 5};
        int score2 = checkScore(answers, submission2);
        maxScore = Math.max(maxScore, score2);
        
        int[] submission3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score3 = checkScore(answers, submission3);
        maxScore = Math.max(maxScore, score3);
        
        ArrayList<Integer> res = new ArrayList<>();
        if (score1 == maxScore)
            res.add(1);
        if (score2 == maxScore)
            res.add(2);
        if (score3 == maxScore)
            res.add(3);
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    public int checkScore(int[] answers, int[] submission) {
        int score = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == submission[i % submission.length])
                score++;
        }
        return score;
    }
}
/*
1번 -> 1~5 반복
- submit1 = [1, 2, 3, 4, 5]
- if (submit1[idx % 5] == answers[idx]) -> 정답!


2번 -> 21232425 반복
- submit2 = [2, 1, 2, 3, 2, 4, 2, 5]
- if (submit1[idx % 8] == answers[idx]) -> 정답!

3번 -> 3311224455 반복
- submit3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
- if (submit1[idx % 10] == answers[idx]) -> 정답!

위 방법을 이용하여 각 수포자별 점수 채점!

최고점 동점자 존재할 경우, 번호를 기준으로 오름차순으로 정렬한다
*/
