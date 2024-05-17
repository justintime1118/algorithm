package leetcode;

//https://leetcode.com/problems/subsets/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int depth = 0; depth <= nums.length; depth++)
            dfs(0, depth, nums, 0, new ArrayDeque<Integer>());

        return ans;
    }

    public void dfs(int depth, int maxDepth, int[] nums, int idx, Deque<Integer> seq) {
        if (depth == maxDepth) {
            ans.add(new ArrayList<>(seq));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            seq.add(nums[i]);
            dfs(depth + 1, maxDepth, nums, i + 1, seq);
            seq.removeLast();
        }
    }
}
/*
 * 중복없이 전체 길이가 0인 조합 ~ nums.length인 조합을 전부 ans에 넣어주면 된다
 */