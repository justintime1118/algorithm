package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.stream.IntStream;

class Solution {

    private static final int[][] RULES = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int maxScore = 0;

        for (int i = 0; i < 3; i++) {
            scores[i] = checkScore(answers, RULES[i]);
            maxScore = Math.max(maxScore, scores[i]);
        }
        
        final int MAX_SCORE = maxScore;

        return IntStream.range(0, 3)
                .filter(i -> scores[i] == MAX_SCORE)
                .map(i -> i + 1)
                .toArray();
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
