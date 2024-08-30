package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++)
            wantMap.put(want[i], number[i]);

        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discountMap.put(
                    discount[i],
                    discountMap.getOrDefault(discount[i], 0) + 1);
        }

        int answer = 0;
        int firstIdx = 0;
        int lastIdx = firstIdx + 9;
        while (true) {
            // 원하는 품목이 할인 품목에 다 들어있는지 체크
            if (isIncluded(wantMap, discountMap))
                answer++;
            // 다음 날짜로 이동
            // 지나간 할인품목 제거
            discountMap.put(
                    discount[firstIdx],
                    discountMap.get(discount[firstIdx]) - 1);
            firstIdx++;
            lastIdx++;
            // 다음 날짜가 날짜 범위를 벗어났으면 종료
            if (lastIdx == discount.length)
                break;
            // 새로운 할인품목 추가
            discountMap.put(
                    discount[lastIdx],
                    discountMap.getOrDefault(discount[lastIdx], 0) + 1);
        }
        return answer;
    }

    public boolean isIncluded(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String key : wantMap.keySet()) {
            if (!discountMap.containsKey(key) || discountMap.get(key) < wantMap.get(key))
                return false;
        }
        return true;
    }
}
/*
 * <M*N(10 * 100,000) 풀이>
 * 자료구조
 * 원하는 품목명과 갯수를 관리하는 wantMap
 * 10일 간 할인 되는 품목명과 갯수를 관리하는 discountMap
 * - 회원 가입 날짜 인덱스(시작점), 가입 인덱스 + 9(끝점)
 * 
 * 알고리즘
 * 가능한 모든 10일의 범위에 대해 discountMap을 한칸씩 옮겨가며 갱신
 * - wantMap에 있는 모든 것들이 discountMap에 포함되어 있는지 확인
 */
