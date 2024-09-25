package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

    int ans = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        // 곡괭이 별 남은 갯수를 담는 맵
        Map<String, Integer> picksMap = new HashMap<>();
        picksMap.put("dia", picks[0]);
        picksMap.put("iron", picks[1]);
        picksMap.put("stone", picks[2]);

        // 남은 광물을 담는 큐
        Queue<String> que = new LinkedList<>();
        for (String mineral : minerals)
            que.add(mineral);

        // picksMap 순회하며 쓸 수 있는 곡괭이만 선택해서 dfs 진행
        for (String p : picksMap.keySet()) {
            if (picksMap.get(p) > 0)
                dfs(p, new HashMap<>(picksMap), new LinkedList<>(que), 0);
        }

        return ans;
    }

    public void dfs(String pick, Map<String, Integer> picksMap, Queue<String> que, int result) {
        // 현 곡괭이로 광물이 남아있는 한 최대 5번까지 광물캐면서 피로도 합산
        for (int i = 0; i < 5 && !que.isEmpty(); i++) {
            result += mine(pick, que.poll());
        }
        // 현 곡괭이 남은 갯수 갱신
        picksMap.put(pick, picksMap.get(pick) - 1);

        // 더 이상 쓸 곡괭이가 없거나, 모든 광물을 캔 경우
        // ans와 피로도 비교해서 최솟값 갱신 후 종료
        if (isPicksMapEmpty(picksMap) || que.isEmpty()) {
            ans = Math.min(ans, result);
            return;
        }

        // 다음 곡괭이 선택
        for (String p : picksMap.keySet()) {
            if (picksMap.get(p) > 0)
                dfs(p, new HashMap<>(picksMap), new LinkedList<>(que), result);
        }
    }

    public boolean isPicksMapEmpty(Map<String, Integer> picksMap) {
        return picksMap.values().stream().allMatch(v -> v <= 0);
    }

    public int mine(String pick, String mineral) {
        int result = 0;

        // 다이아 곡괭이
        if (pick.equals("dia")) {
            result = 1;
        }
        // 철 곡괭이
        else if (pick.equals("iron")) {
            if (mineral.equals("diamond"))
                result = 5;
            else
                result = 1;
        }
        // 돌 곡괭이
        else {
            if (mineral.equals("diamond"))
                result = 25;
            else if (mineral.equals("iron"))
                result = 5;
            else
                result = 1;
        }

        return result;
    }
}