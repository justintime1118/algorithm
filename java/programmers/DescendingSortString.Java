import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12917

class Solution {
    public String solution(String s) {
        char[] sortedStr = s.toCharArray();
        Arrays.sort(sortedStr);
        StringBuffer ans = new StringBuffer(sortedStr.length);
        for (int i = sortedStr.length - 1; i >= 0; i--) {
            ans.append(sortedStr[i]);
        }
        return new String(ans);
    }
}