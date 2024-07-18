package leetcode;

//https://leetcode.com/problems/binary-search/description/

class Solution {
    public int search(int[] nums, int target) {
        return bs(0, nums.length - 1, target, nums);
    }

    public int bs(int left, int right, int target, int[] nums) {
        int idx = (left + right) / 2;

        // 종료조건
        if (left > right)
            return -1;

        // 분기처리
        if (nums[idx] < target)
            return bs(idx + 1, right, target, nums);
        else if (nums[idx] > target)
            return bs(left, idx - 1, target, nums);
        else
            return idx;
    }
}
