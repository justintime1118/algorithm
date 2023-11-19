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

    /* 내가 생각해낸 다른풀이 
    public int[] solution(long n) {
        char[] charArr = (n + "").toCharArray();
        int[] ans = new int[charArr.length];
        
        for (int i = charArr.length - 1; i >= 0; i--) {
            // ans[charArr.length - 1 - i] = Integer.valueOf(charArr[i]) - Integer.valueOf('0'); // 아래와 같은 결과
            ans[charArr.length - 1 - i] = Character.getNumericValue(charArr[i]);
        }
        return ans;
    }
    */

    /* 책에서 소개된 풀이 (문자열 클래스 이용)
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }
        
        return result;
    }
     */
}