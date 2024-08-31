package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothing : clothes) {
            clothesMap.put(
                    clothing[1],
                    clothesMap.getOrDefault(clothing[1], 1) + 1
            // -> 모든 옷 종류에 대해 옷을 안입는 경우의 수 1을 더 추가해줌
            );
        }
        int ans = 1;
        for (String key : clothesMap.keySet()) {
            ans *= clothesMap.get(key);
        }
        return ans - 1;
    }
}
/*
 * 해시맵을 이용해서 종류 별로 그룹화해서 넣어두기
 * 
 * 의상 종류와 종류 내의 갯수를 이용하여 조합의 갯수 계산
 * -> 전체 갯수에 의상을 안입는 옵션을 1개씩 더해주고 곱셈 한 뒤에 마지막에 1 빼주기
 */