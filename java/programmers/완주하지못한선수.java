package programmers;

//문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> compMap = new HashMap<>();
        for (String c : completions) {
            compMap.put(c, compMap.getOrDefault(c, 0) + 1);
        }

        for (String p : participants) {
            if (compMap.getOrDefault(p, 0) == 0)
                return p;
            compMap.put(p, compMap.get(p) - 1);
        }

        return null;
    }
}
/*
 * 해시 맵을 만들어서 completion을 싹 다 넣고,
 * participant를 싹 빼면
 * 마지막에 남는 녀석이 답
 * 
 * 동명이인 처리가 핵심
 */