package leetcode;

// https://leetcode.com/problems/reverse-string/description/

class Solution {
    public void reverseString(char[] s) {
        char tmp = 0;
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            tmp = s[len - i - 1];
            s[len - i - 1] = s[i];
            s[i] = tmp;
        }
    }
}