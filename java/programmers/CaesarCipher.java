package programmers;

// 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12926

class Solution {
    public String solution(String s, int n) {
        char[] ans = s.toCharArray();
        char cur;
        for (int i = 0; i < ans.length; i++) {
            cur = ans[i];
            if (cur == ' ') {
                continue;
            } else if ('a' <= cur && cur <= 'z') {
                if (cur + n > 'z')
                    cur -= 26;
            } else {
                if (cur + n > 'Z')
                    cur -= 26;
            }
            ans[i] = (char)(cur + n);
        }
        return new String(ans);
    }
}
