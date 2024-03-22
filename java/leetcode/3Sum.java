package leetcode;

//https://leetcode.com/problems/3sum/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            //중복 제거
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            //투포인터로 그 합이 -nums[i]와 같아지는 두 수 구하기
            getTriplet(nums, i, ans);
        }
        
        return ans;
    }

    public void getTriplet(int[] nums, int i, List<List<Integer>> ans) {
        int num = nums[i];
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[i] + nums[left] + nums[right] == 0) {
                //중복 제거
                if (!(left > i + 1 && nums[left] == nums[left - 1])) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                }
                left++;
                right--;
            }
            else if (nums[i] + nums[left] + nums[right] < 0) {
                left++;
            }
            else {
                right--;
            }
        }
    }
}