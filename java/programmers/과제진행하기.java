package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String[] solution(String[][] plans) {
        // plans를 시작 시간 순으로 오름차순 정렬 후 plansQue에 넣는다
        Arrays.sort(plans, (p1, p2) -> p1[1].compareTo(p2[1]));
        Queue<String[]> plansQue = new LinkedList<>();
        for (String[] plan : plans)
            plansQue.add(plan);

        // 중도에 멈춘 작업들을 보관할 스택
        Deque<String[]> waitingQue = new ArrayDeque<>();

        // 정답을 담을 리스트
        List<String> ans = new ArrayList<>();

        // plans를 순회
        while (!plansQue.isEmpty()) {
            String[] plan = plansQue.poll();
            // 마지막 과제에 도달했으면 ans에 바로 추가하고 종료
            if (plansQue.isEmpty()) {
                ans.add(plan[0]);
                break;
            }
            // (다음 과제 시작시간 - 현 과제 시작시간) 계산
            int minutesLeft = calculateMinutesBetween(plan[1], plansQue.peek()[1]);

            // 다음 과제 시작 전에 끝나는 경우
            if (Integer.valueOf(plan[2]) <= minutesLeft) {
                // 현 과제 완료 후 남은 시간 갱신
                ans.add(plan[0]);
                minutesLeft -= Integer.valueOf(plan[2]);
                // 다음 과제 시작까지 남은 시간을 이용해서 대기 큐 처리
                while (!waitingQue.isEmpty() && minutesLeft > 0) {
                    if (Integer.valueOf(waitingQue.peek()[2]) <= minutesLeft) {
                        ans.add(waitingQue.peek()[0]);
                        minutesLeft -= Integer.valueOf(waitingQue.pop()[2]);
                    } else {
                        waitingQue.peek()[2] = String.valueOf(Integer.valueOf(waitingQue.peek()[2]) - minutesLeft);
                        break;
                    }
                }
            }
            // 다음 과제 시작 전까지 끝나지 않으면 그 사이에 경과된 시간만큼을 차감하여, 대기 큐에 추가
            else {
                plan[2] = String.valueOf(Integer.valueOf(plan[2]) - minutesLeft);
                waitingQue.push(plan);
            }
        }

        // plansQue 전체 순회한 뒤, waitingQue에 담겨있는 작업 순서대로 ans에 추가
        while (!waitingQue.isEmpty())
            ans.add(waitingQue.pop()[0]);

        return ans.toArray(new String[ans.size()]);
    }

    public int calculateMinutesBetween(String from, String to) {
        int fromHour = Integer.valueOf(from.split(":")[0]);
        int fromMin = Integer.valueOf(from.split(":")[1]);
        int toHour = Integer.valueOf(to.split(":")[0]);
        int toMin = Integer.valueOf(to.split(":")[1]);

        int hour = fromMin < toMin ? toHour - fromHour : toHour - fromHour - 1;
        int min = fromMin < toMin ? toMin - fromMin : 60 - fromMin + toMin;
        return hour * 60 + min;
    }
}