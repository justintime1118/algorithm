package leetcode;

//문제 링크: https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int maxDepth;
    int maxNum;

    public List<List<Integer>> combine(int n, int k) {
        maxDepth = k;
        maxNum = n;

        dfs(0, 0, new ArrayList<Integer>());

        return ans;
    }

    public void dfs(int depth, int idx, List<Integer> seq) {
        if (depth == maxDepth) {
            ans.add(new ArrayList<Integer>(seq));
            return;
        }

        for (int i = idx + 1; i <= maxNum; i++) {
            seq.add(i);
            dfs(depth + 1, i, seq);
            seq.removeLast();
        }
    }
}