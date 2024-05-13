package leetcode;

// 문제 링크: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int ans = 0;
        int begin = 0;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (!set.contains(c)) {
                set.add(c);
                ans = Math.max(ans, set.size());
            } else {
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
 * substring이 될 슬라이딩 윈도우를 만든다
 * 빠른 중복체크를 위해 substring의 원소들은 set에 담아둔다
 * 
 * s를 순회하면서
 * 윈도우를 키울 수 있으면(set에 없는 문자면) 키운다 & ans 갱신
 * 키울 수 없으면(set에 있는 문자면), 기존에 가지고 있던 문자가 set에서 빠질때까지 왼쪽 포인터를 끌어당겨온다
 */