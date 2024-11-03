package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/340198
// 21분 소요, 최초 1회 제출로 정답

import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // mats를 내림차순 정렬
        int[] sortedMats = Arrays.stream(mats)
                .boxed()
                .sorted((e1, e2) -> Integer.compare(e2, e1))
                .mapToInt(Integer::intValue)
                .toArray();

        // mats에서 하나씩 꺼내서 해당 크기의 정사각형 빈공간 있는지 확인
        for (int size : sortedMats) {
            if (hasSpace(size, park))
                return size;
        }

        return -1;
    }

    public boolean hasSpace(int size, String[][] park) {
        // 돗자리 좌측 최상단이 들어갈 빈공간을 우선 찾음
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                // 찾았으면 돗자리 크기만큼 빈공간이 되는지 확인
                if (hasSpace(i, j, size, park))
                    return true;
            }
        }

        return false;
    }

    public boolean hasSpace(int row, int col, int size, String[][] park) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 공원의 범위를 벗어나거나, 이미 점유된 공간이 포함되어 있으면 불가능
                if (park.length <= i || park[0].length <= j
                        || !park[i][j].equals("-1"))
                    return false;
            }
        }

        return true;
    }
}

/*
 * <전체 개략적 로직>
 * mats를 내림차순 정렬
 * mats에서 하나씩 꺼내가며 정사각형 빈공간 있는지 확인
 * -> 있으면 해당 길이 리턴
 * 
 * 없으면 -1 리턴
 * 
 * <핵심 로직>
 * 빈공간 확인
 * -> 해당 돗자리의 좌측 최상단이 들어갈 빈공간을 일단 찾음
 * -> 찾았으면 거기서부터 정사각형 크기만큼의 공간이 비어있는지 확인함
 */