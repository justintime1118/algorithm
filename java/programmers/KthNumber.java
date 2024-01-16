package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] ans = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] newArray = Arrays.copyOf(array, array.length);
            ans[i] = cutAndSort(newArray, commands[i][0] - 1, commands[i][1], commands[i][2] - 1);
        }
        return ans;
    }
    
    public int cutAndSort(int[] array, int start, int end, int idx) {
        int[] subArray = Arrays.copyOfRange(array, start, end);
        Arrays.sort(subArray);
        return subArray[idx];
    }
}