package programmers;

//문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67256

class Solution {

    int[][] keypad = {
            { 3, 1 }, // 0
            { 0, 0 }, { 0, 1 }, { 0, 2 }, // 1, 2, 3
            { 1, 0 }, { 1, 1 }, { 1, 2 }, // 4, 5, 6
            { 2, 0 }, { 2, 1 }, { 2, 2 }, // 7, 8, 9

    };

    public int getDistance(int[] cur, int[] prev) {
        int distance = 0;
        // 행 간 거리
        distance += Math.max(cur[0], prev[0]) - Math.min(cur[0], prev[0]);
        // 열 간 거리
        distance += Math.max(cur[1], prev[1]) - Math.min(cur[1], prev[1]);
        return distance;
    }

    public String solution(int[] numbers, String hand) {
        int[] lThumb = { 3, 0 }; // *
        int[] rThumb = { 3, 2 }; // #
        StringBuffer ans = new StringBuffer(numbers.length);

        for (int num : numbers) {
            // 왼쪽 열은 왼손
            if (num == 1 || num == 4 || num == 7) {
                lThumb = keypad[num];
                ans.append("L");
            }
            // 오른쪽 열은 오른손
            else if (num == 3 || num == 6 || num == 9) {
                rThumb = keypad[num];
                ans.append("R");
            }
            // 가운데는 이전 위치 또는 자주 쓰는 손
            else {
                // 이전 위치로부터 거리 계산
                int lDistance = getDistance(lThumb, keypad[num]);
                int rDistance = getDistance(rThumb, keypad[num]);

                // 거리에 따른 분기처리
                if (lDistance < rDistance) {
                    lThumb = keypad[num];
                    ans.append("L");
                } else if (rDistance < lDistance) {
                    rThumb = keypad[num];
                    ans.append("R");
                }
                // 거리가 같으면 주로 사용하는 손으로
                else {
                    if (hand.equals("left")) {
                        lThumb = keypad[num];
                        ans.append("L");
                    } else {
                        rThumb = keypad[num];
                        ans.append("R");
                    }
                }
            }
        }
        return ans.toString();
    }
}