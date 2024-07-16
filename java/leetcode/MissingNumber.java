package leetcode;

//https://leetcode.com/problems/missing-number/description/

import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return nums.length;
    }
}