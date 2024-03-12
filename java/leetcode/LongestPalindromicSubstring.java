package leetcode;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;

        int len = s.length();
        String ans = s.substring(0, 1);
        char[] charArr = s.toCharArray();
        for (int length = len; length > 0; length--) {
            for (int start = 0; start + length <= len; start++) {
                if (isPalindrome(charArr, start, start + length - 1) == true) {
                    return s.substring(start, start + length);
                }
            }
        }
        return ans;
    };

    public boolean isPalindrome(char[] arr, int left, int right) {

        while (left < right) {
            if (arr[left] != arr[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
