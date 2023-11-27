package programmers;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12916

class Solution {
    boolean solution(String s) {
        
        int pCnt = 0;
        int yCnt = 0;
        
        for (char c : s.toUpperCase().toCharArray()) {
            if (c == 'P')
                pCnt++;
            else if (c == 'Y')
                yCnt++;
        }
        
        return pCnt == yCnt;
    }
    /*
    교재 풀이
    boolean solution(String s) {

        s = s.toLowerCase();
        
        int pCnt = s.length() - s.replace("p", "").length();
        int yCnt = s.length() - s.replace("y", "").length();
        return pCnt == yCnt;
    }
    */
}