package leetcode;

//문제 링크: https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int maxDepth;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        maxDepth = nums.length;

        dfs(0, new ArrayList<Integer>(), nums);

        return ans;
    }

    public void dfs(int depth, List<Integer> seq, int[] nums) {
        if (depth == maxDepth) {
            ans.add(new ArrayList<Integer>(seq));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            List<Integer> nextSeq = new ArrayList<>(seq);
            nextSeq.add(nums[i]);

            dfs(depth + 1, nextSeq, nums);

            used[i] = false;

        }
    }
}