package leetcode;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;

        String ans = s.substring(0, 1);
        for (int begin = 0; begin < s.length() - 1; begin++) {
            for (int end = begin + 1; end < s.length(); end++) {
                String tmp = s.substring(begin, end + 1);
                if (isPalindrome(tmp) == true) {
                    ans = tmp.length() > ans.length()
                            ? tmp
                            : ans;
                }
            }
        }
        return ans;
    };

    public boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String reversedStr = new String(sb);
        return str.equals(reversedStr);
    }
}
