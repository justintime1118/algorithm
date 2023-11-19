package programmers;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12932

import java.util.*;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add((int)(n % 10L));
            n = (int)(n / 10L);
        }
        return arr.stream().mapToInt(x -> (int)x).toArray();
    }
}