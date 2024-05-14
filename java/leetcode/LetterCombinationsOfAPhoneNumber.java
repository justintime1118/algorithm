package leetcode;

//문제 링크: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxDepth;
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        maxDepth = digits.length();
        if (maxDepth == 0)
            return new ArrayList<String>();

        dfs(0, "", digits.split(""));
        return ans;
    }

    public void dfs(int depth, String comb, String[] digits) {
        if (depth == maxDepth) {
            ans.add(comb);
            return;
        }
        for (String digit : digits[depth].split("")) {
            if (digit.equals("2")) {
                dfs(depth + 1, comb + "a", digits);
                dfs(depth + 1, comb + "b", digits);
                dfs(depth + 1, comb + "c", digits);
            } else if (digit.equals("3")) {
                dfs(depth + 1, comb + "d", digits);
                dfs(depth + 1, comb + "e", digits);
                dfs(depth + 1, comb + "f", digits);
            } else if (digit.equals("4")) {
                dfs(depth + 1, comb + "g", digits);
                dfs(depth + 1, comb + "h", digits);
                dfs(depth + 1, comb + "i", digits);
            } else if (digit.equals("5")) {
                dfs(depth + 1, comb + "j", digits);
                dfs(depth + 1, comb + "k", digits);
                dfs(depth + 1, comb + "l", digits);
            } else if (digit.equals("6")) {
                dfs(depth + 1, comb + "m", digits);
                dfs(depth + 1, comb + "n", digits);
                dfs(depth + 1, comb + "o", digits);
            } else if (digit.equals("7")) {
                dfs(depth + 1, comb + "p", digits);
                dfs(depth + 1, comb + "q", digits);
                dfs(depth + 1, comb + "r", digits);
                dfs(depth + 1, comb + "s", digits);
            } else if (digit.equals("8")) {
                dfs(depth + 1, comb + "t", digits);
                dfs(depth + 1, comb + "u", digits);
                dfs(depth + 1, comb + "v", digits);
            } else {
                dfs(depth + 1, comb + "w", digits);
                dfs(depth + 1, comb + "x", digits);
                dfs(depth + 1, comb + "y", digits);
                dfs(depth + 1, comb + "z", digits);
            }
        }
    }
}