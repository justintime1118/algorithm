package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/77486

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amounts) {
        // <판매원, 추천인> <자식, 부모>
        Map<String, String> tree = new HashMap<>();
        // <판매원, 누적 이익금>
        Map<String, Integer> profitMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            tree.put(enroll[i], referral[i]);
            profitMap.put(enroll[i], 0);
        }

        for (int i = 0; i < sellers.length; i++) {
            String seller = sellers[i];
            int profit = amounts[i] * 100;
            int profitToReferral;
            int profitToSeller;
            // 자식에서 부모로 타고 올라가며 이익금 분배
            while (true) {
                profitToReferral = profit / 10;
                profitToSeller = profit - profitToReferral;
                profitMap.put(seller, profitMap.getOrDefault(seller, 0) + profitToSeller);
                seller = tree.get(seller);
                profit = profitToReferral;
                // root에 도달한 경우 또는 분배 못할만큼 이익금이 작아지면 stop
                if (seller.equals("-") || profit == 0)
                    break;
            }
        }

        int[] ans = new int[enroll.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = profitMap.get(enroll[i]);
        }
        return ans;
    }
}