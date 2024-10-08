package leetcode;

// 문제 링크: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 빠른 중복체크를 위한 set
        Set<Character> set = new HashSet<>();

        int ans = 0;
        int begin = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            // set에 없는 문자면, 윈도우를 키우고 ans 갱신
            if (!set.contains(c)) {
                set.add(c);
                ans = Math.max(ans, set.size());
            }
            // set에 있는 문자면, 해당 문자가 set에서 빠질때까지 왼쪽 포인터(begin)를 끌어당겨온다
            else {
                while (set.contains(c)) {
                    set.remove(charArr[begin]);
                    begin++;
                }
                set.add(c);
            }
        }
        return ans;
    }
}
/*
 * <핵심 아이디어>
 * 문자열 내에 서로 같은 알파벳이 여러개 존재한다
 * 그 사이의 길이가 가장 긴 녀석이 정답이다
 * 투포인터로 우측으로 이동, set으로 중복체크
 * 중복되지 않으면서 길이가 가장 길게 나온 순간이 정답
 */