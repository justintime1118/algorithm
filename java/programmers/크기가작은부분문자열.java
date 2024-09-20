package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/147355#

class Solution {
    public int solution(String t, String p) {
        int ans = 0;
        int len = p.length();
        long val = Long.valueOf(p);
        // 문자열 t 전체를 순회
        for (int i = 0; i <= t.length() - len; i++) {
            // 길이가 len인 부분문자열 추출
            String sub = t.substring(i, i + len);
            // (p가 나타내는 수 >= 부분문자열이 나타내는 수)인 경우
            if (Long.compare(val, Long.valueOf(sub)) >= 0)
                ans++;
        }
        return ans;
    }
}
/*
 * 제출 시, 계속 런타임 에러가 발생해서 substring의 인덱스 부분만 계속 체크헸는데
 * 알고보니 p의 값을 int에 담으려고 시도한 부분이 에러 발생 지점이었다.
 * 최대 길이가 18이라는 문제의 제한사항을 간과한 것이 문제!
 */