package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();

        // 모든 작업을 순회
        int i = 0;
        int days = 0;
        int deployCnt = 0;
        while (i < progresses.length) {
            // 현재 작업이 완료될 때까지 걸리는 일수 계산
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                days++;
            }
            // 현재 작업은 완료되었으므로 배포 갯수를 더해주고 다음 작업으로 넘어감
            deployCnt++;
            i++;
            // 걸린 일수만큼 진도를 갱신해가며 총 몇개의 다음 작업들이 한번에 배포되는지 계산
            while (i < progresses.length) {
                progresses[i] += speeds[i] * days;
                if (progresses[i] >= 100) {
                    deployCnt++;
                    i++;
                } else
                    break;
            }
            // 한번에 배포되는 작업 갯수를 ans에 add
            ans.add(deployCnt);
            deployCnt = 0;
        }

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}