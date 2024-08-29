package programmers;

//문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> partMap = new HashMap<>();
        for (String p : participants) {
            partMap.putIfAbsent(p, 0);
            partMap.put(p, partMap.get(p) + 1);
        }

        for (String c : completions) {
            partMap.put(c, partMap.get(c) - 1);
            if (partMap.get(c) == 0)
                partMap.remove(c);
        }

        String ans = null;
        for (String unfinished : partMap.keySet())
            ans = unfinished;

        return ans;
    }
}
/*
 * 해시 맵을 만들어서 participant를 싹 다 넣고,
 * completion에 있는 애들을 싹 빼면
 * 마지막에 남는 녀석이 답
 * 
 * 동명이인 처리가 핵심
 */