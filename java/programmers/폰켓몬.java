package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int n = nums.length;

        // 전체 종류의 개수가 n/2보다 크면 모두 다른 다른 종류로 고를 수 있음
        // 전체 종류의 개수가 n/2보다 작으면 모든 종류를 사용함
        return set.size() >= n / 2 ? n / 2 : set.size();
    }
}
