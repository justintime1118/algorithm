package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/12910

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        int[] ans = Arrays.stream(arr)
                .filter(n -> n % divisor == 0)
                .sorted()
                .toArray();
        return ans.length > 0 ? ans : new int[] { -1 };
    }
}