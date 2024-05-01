package programmers;

//문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42576
import java.util.HashMap;
import java.util.Map;

class Solution {

    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> cCounter = new HashMap<String, Integer>();
        for (String comp : completions) {
            cCounter.put(comp, cCounter.getOrDefault(comp, 0) + 1);
        }

        String ans = null;
        for (String part : participants) {
            if (!cCounter.containsKey(part) || cCounter.get(part) == 0) {
                ans = part;
                break;
            }
            cCounter.put(part, cCounter.get(part) - 1);
        }

        return ans;
    }
}
/*
 * 동명이인 처리를 위해 Set이 아닌 Map을 쓰는 것이 바람직
 * Map을 Counter처럼 사용하면 쉽게 풀 수 있겠다
 */