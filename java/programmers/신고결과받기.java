package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=java

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> reportedMap = new HashMap<>();
        for (String report : reports) {
            String[] parsedReport = report.split(" ");
            String reporter = parsedReport[0];
            String reported = parsedReport[1];

            reportedMap.putIfAbsent(reported, new HashSet<>());
            reportedMap.get(reported).add(reporter);
        }

        Map<String, Integer> result = new HashMap<>();
        for (String reported : reportedMap.keySet()) {
            Set<String> reporterSet = reportedMap.get(reported);
            if (reporterSet.size() >= k) {
                for (String reporter : reporterSet)
                    result.put(reporter, result.getOrDefault(reporter, 0) + 1);
            }
        }

        int[] ans = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            ans[i] = result.getOrDefault(reporter, 0);
        }
        return ans;
    }
}
/*
 * <필요한 것 및 풀이 로직>
 * 각 유저별 신고현황 및 신고 당한 횟수
 * - Map<String, Set<String>> reportedMap // <피신고자, 신고자 세트>
 * 각 유저별로 자기가 신고한 사람 중 K번 이상 신고당한 사람의 명수
 * - Map<String, Integer> result
 * - reportedMap을 순회하면서 set의 사이즈가 k 이상인 애들의 set에 들어있는 ID마다 1씩 더해줌
 * 
 * int[] ans를 선언
 * - for 문으로 id_list를 순회
 * - 해당 id를 result에 넣어가며 id 인덱스와 그에 해당하는 값을 ans에 채워주면 끝
 */
