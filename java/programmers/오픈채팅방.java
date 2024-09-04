package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] records) {

        Map<String, String> nicknameMap = new HashMap<>();
        for (String record : records) {
            String[] parsed = record.split(" ");
            if (parsed[0].equals("Enter")
                    || parsed[0].equals("Change")) {
                nicknameMap.put(parsed[1], parsed[2]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String record : records) {
            String[] parsed = record.split(" ");
            if (parsed[0].equals("Enter")) {
                ans.add(nicknameMap.get(parsed[1]) + "님이 들어왔습니다.");
            }
            if (parsed[0].equals("Leave")) {
                ans.add(nicknameMap.get(parsed[1]) + "님이 나갔습니다.");
            }
        }

        return ans.stream()
                .toArray(String[]::new);
    }
}

/*
 * <핵심 과제>
 * - 메시지의 순서는 닉네임 변경과 상관없이 그대로 지켜져야 한다
 * - 닉네임 변경이 일어나는 두가지 경우 모두에 대해 전체 메시지가 모두 적절하게 처리되도록 하는 것
 * - 닉네임이 동일하더라도 유저아이디를 이용해서 누구의 메시지인지를 다 구분해줘야 함
 * 
 * <구현 방법>
 * - 유저 아이디와 닉네임, 메시지를 모두 적절히 관리할 수 있는 자료구조를 잘 마련해야 함
 * 
 * Map<String, String> nicknameMap으로 <유저아이디, 닉네임>을 저장
 * 
 * record 순회
 * - 유저의 닉네임이 최종적으로 어떻게 결정되는지만 기록해둠
 * -> Enter면 nicknameMap에 추가 또는 변경 처리
 * -> change면 변경 처리
 * 
 * 다시 record 순회
 * - Enter와 Leave가 나올때마다 해당 유저아이디에 대한 닉네임을 붙여서 만들어지는 문자열을 정답배열에 차례로 넣어줌
 */