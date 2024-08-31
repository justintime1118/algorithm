package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/17684

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String msg) {
        // 사전 초기화
        Map<String, Integer> dict = new HashMap<>();
        char c = 'A';
        while (c <= 'Z')
            dict.put(Character.toString(c++), dict.size() + 1);

        // 정답을 기록할 배열 리스트
        List<Integer> ans = new ArrayList<>();

        int from = 0;
        int to = 0;
        while (to <= msg.length()) {
            // msg 중 처리되지 않은 남은 단어의 맨 앞에서부터 사전에 있는 가장 긴 단어를 찾는다
            if (to < msg.length() && dict.containsKey(msg.substring(from, to + 1)))
                to++;
            // 색인번호 입력
            else {
                ans.add(dict.get(msg.substring(from, to)));
                // 다음 글자가 없으면 종료
                if (to == msg.length())
                    break;
                // 다음 글자가 있으면 (찾은 단어 + 다음 글자)를 사전에 등록
                dict.put(msg.substring(from, to + 1), dict.size() + 1);
                // 처리된 글자는 넘어감
                from = to;
            }

        }
        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
