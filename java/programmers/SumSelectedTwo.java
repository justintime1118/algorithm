package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68644

import java.util.*;

class Solution {
    public int[] solution(int[] nbr) {
        Set<Integer> nbrSet = new HashSet<>();

        for (int i = 0; i < nbr.length - 1; i++) {
            for (int j = i + 1; j < nbr.length; j++) {
                nbrSet.add(nbr[i] + nbr[j]);
            }
        }

        return nbrSet.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}