package leetcode;

// https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String str) {
        String processedStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(processedStr).reverse().toString();
        return processedStr.equals(reversedStr);
    }
}