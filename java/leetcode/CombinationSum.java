package leetcode;

//문제 링크: https://leetcode.com/problems/combination-sum/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(0, new ArrayDeque<Integer>(), 0, candidates, target);

        return ans;
    }

    public void dfs(int idx, Deque<Integer> seq, int sum, int[] candidates, int target) {
        if (sum > target)
            return;
        if (sum == target) {
            ans.add(new ArrayList<>(seq));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            seq.add(candidates[i]);
            dfs(i, seq, sum + candidates[i], candidates, target);
            seq.removeLast();
        }
    }
}

/*
 * 일단 정렬시킴 -> sum이 target보다 커지는 경우의 수들을 최대한 빠르게 가지치기 할 수 있음
 * 
 * 무제한 중복선택이 가능하도록 dfs를 돌린다
 * target과 정확히 같은 수가 나오면 ans에 담아주고 중단
 * target 보다 커지면 그냥 중단
 */