package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68644

import java.util.*;

class Solution {
    public int[] solution(int[] nbr) {
    
        // 서로 다른 두개의 원소를 더해서 만들 수 있는 모든 수를 중복을 허용하여 tmp 배열에 저장한다
        int len = nbr.length;
        int tmp_len = (len * (len - 1)) / 2; // 순열과 조합에서 조합 공식을 사용
        int[] tmp = new int[tmp_len];
        for (int i = 0, idx = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++)
                tmp[idx++] = (nbr[i] + nbr[j]);
        }
        
        // tmp 배열을 오름차순으로 정렬한다
        Arrays.sort(tmp);

        // 중복인 원소들이 있으면 하나만 남기고 나머지 원소들은 -1로 대체시킨다
        // 중복을 제거하고 남은 숫자가 총 몇개인지를 세어둔다
        int ans_len = tmp_len;
        for (int i = 0; i < tmp_len - 1; i++) {
            if (tmp[i] == tmp[i + 1]) {
                tmp[i] = -1;
                ans_len--;
            }
        }
        
        // 중복이 제거된 배열 ans를 만들어 리턴한다
        int[] ans = new int[ans_len];
        for (int i = 0, idx = 0; i < tmp_len; i++) {
            if (tmp[i] != -1)
                ans[idx++] = tmp[i];
        }
        return ans;
    }
}