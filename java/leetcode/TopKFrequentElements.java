package leetcode;

//문제 링크: https://leetcode.com/problems/top-k-frequent-elements/

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : nums)
            counter.put(i, counter.getOrDefault(i, 0) + 1);

        Queue<Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        for (Entry<Integer, Integer> e : counter.entrySet())
            pq.add(e);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
/*
 * 첫번째~k번째로 가장 많이 출현한 integer를 배열에 담아서 리턴
 * 'k번째'가 중요한 포인트
 * HashMap<Integer, Integer>에 특정 숫자에 대한 counter를 만들어서 기록
 * map의 모든 엔트리를 우선순위 큐에 담음. 이때, 타입 안정성을 위해 Entry<>에 타입 표기를 잘해주자
 * 단,우선순위 큐는 역순정렬(max heap처럼 큰 값이 먼저 나옴)
 * k번 poll하면 끝
 */