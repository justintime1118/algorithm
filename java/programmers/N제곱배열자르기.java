package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/87390

import java.util.stream.LongStream;

class Solution {
    public int[] solution(int n, long left, long right) {
        return LongStream.rangeClosed(left, right)
                .mapToInt(idx -> (int) Math.max(idx / n, idx % n) + 1)
                .toArray();
    }
}