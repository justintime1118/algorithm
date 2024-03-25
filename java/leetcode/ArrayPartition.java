package leetcode;

//https://leetcode.com/problems/array-partition/description/

import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // 배열 정렬
        Arrays.sort(nums);

        // 짝수 인덱스만 골라서 더한 후 리턴
        // (0,1), (2,3), ...으로 짝을 이룬 뒤 더 작은 것을 고르는 것과 같음
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                ans += nums[i];
        }
        return ans;
    }
}