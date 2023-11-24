package programmers;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68935

class Solution {
    public int solution(int n) {
        return Integer.valueOf(new StringBuffer(Integer.toString(n, 3)) // 3진법 변환
                               .reverse() // 뒤집기
                               .toString(), 3); // 10진법으로 표현
    }
}