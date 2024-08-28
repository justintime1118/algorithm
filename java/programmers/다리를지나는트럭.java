package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static class Truck {
        int weight;
        int enteringTime;

        public Truck(int weight, int enteringTime) {
            this.weight = weight;
            this.enteringTime = enteringTime;
        }
    }

    public int solution(int bridgeLen, int weightLimit, int[] weights) {
        // 다리에 올라간 전체 트럭 무게의 합
        int totalWeight = 0;
        // 대기 트럭 큐
        Queue<Integer> waitingQue = new LinkedList<>();
        for (int weight : weights)
            waitingQue.add(weight);
        // 다리에 올라가 있는 트럭 큐
        Queue<Truck> onBridgeQue = new LinkedList<>();

        int time = 0;
        while (!onBridgeQue.isEmpty() || !waitingQue.isEmpty()) {
            time++;
            // 다리 끝에 도달했으면 빠져나가도록 처리
            if (!onBridgeQue.isEmpty()
                    && time - onBridgeQue.peek().enteringTime >= bridgeLen) {

                totalWeight -= onBridgeQue.poll().weight;
            }
            // 무게제한 내에 있다면 다음 트럭 진입
            if (!waitingQue.isEmpty()
                    && totalWeight + waitingQue.peek() <= weightLimit) {

                totalWeight += waitingQue.peek();
                onBridgeQue.add(new Truck(waitingQue.poll(), time));
            }
        }

        return time;
    }
}
/*
 * <풀이 로직>
 * 반복문 한번 도는 것을 1초로 두고 시뮬레이션
 * - 끝에 도달한 트럭 큐에서 제거
 * - 다리 무게 제한을 만족하면 트럭 진입
 * 
 * <다리에서 빠져나오는 예시>
 * 다리 길이는 2 -> 2초간 다리 위에 있어야 함
 * 4초에 진입 -> 4초일 때 다리 위에 있음, 5초까진 다리 위에 있어야 함
 * 6초부터 빠져나올 수 있음
 * 다리에서 빠져나오는 조건식: 6(현재 시점) - 4(진입 시점) >= 2(다리 길이)
 */