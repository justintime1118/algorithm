package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // 데이터명과 인덱스를 매핑한 맵
        Map<String, Integer> datanameToIdx = new HashMap<>();
        datanameToIdx.put("code", 0);
        datanameToIdx.put("date", 1);
        datanameToIdx.put("maximum", 2);
        datanameToIdx.put("remain", 3);

        return Arrays.stream(data)
                .filter(e -> e[datanameToIdx.get(ext)] < val_ext)
                .sorted((e1, e2) -> e1[datanameToIdx.get(sort_by)] - e2[datanameToIdx.get(sort_by)])
                .toArray(int[][]::new);

    }
}
/*
 * data를 스트림으로 변환
 * - 스트림의 원소들은 int[]가 됨. 즉 개별 데이터 row들이 됨
 * ext 값이 val_ext보다 작은 데이터들만 필터링
 * - ext가 몇번째 인덱스에 해당하는 값인지 map을 통해 구해냄
 * sort_by를 기준으로 오름차순 정렬
 * - sort_by가 몇번째 인덱스에 해당하는 값인지 map을 통해 구해냄
 */