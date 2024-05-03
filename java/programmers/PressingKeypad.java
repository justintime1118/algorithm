package programmers;

//문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67256

class Solution {
    int[] ONE = { 0, 0 };
    int[] TWO = { 0, 1 };
    int[] THREE = { 0, 2 };

    int[] FOUR = { 1, 0 };
    int[] FIVE = { 1, 1 };
    int[] SIX = { 1, 2 };

    int[] SEVEN = { 2, 0 };
    int[] EIGHT = { 2, 1 };
    int[] NINE = { 2, 2 };

    int[] STAR = { 3, 0 };
    int[] ZERO = { 3, 1 };
    int[] SHARP = { 3, 2 };

    public int getDistance(int[] cur, int[] prev) {
        int distance = 0;
        // 행 간 거리
        distance += Math.max(cur[0], prev[0]) - Math.min(cur[0], prev[0]);
        // 열 간 거리
        distance += Math.max(cur[1], prev[1]) - Math.min(cur[1], prev[1]);
        return distance;
    }

    public int[] numberToCoor(int num) {
        if (num == 1)
            return ONE;
        else if (num == 2)
            return TWO;
        else if (num == 3)
            return THREE;
        else if (num == 4)
            return FOUR;
        else if (num == 5)
            return FIVE;
        else if (num == 6)
            return SIX;
        else if (num == 7)
            return SEVEN;
        else if (num == 8)
            return EIGHT;
        else if (num == 9)
            return NINE;
        else // num == 0
            return ZERO;
    }

    public String solution(int[] numbers, String hand) {
        int[] lThumb = STAR;
        int[] rThumb = SHARP;
        StringBuffer ans = new StringBuffer(numbers.length);

        for (int num : numbers) {
            // 왼쪽 열은 왼손
            if (num == 1 || num == 4 || num == 7) {
                lThumb = numberToCoor(num);
                ans.append("L");
            }
            // 오른쪽 열은 오른손
            else if (num == 3 || num == 6 || num == 9) {
                rThumb = numberToCoor(num);
                ans.append("R");
            }
            // 가운데는 이전 위치 또는 자주 쓰는 손
            else {
                // 이전 위치로부터 거리 계산
                int lDistance = getDistance(lThumb, numberToCoor(num));
                int rDistance = getDistance(rThumb, numberToCoor(num));

                // 거리에 따른 분기처리
                if (lDistance < rDistance) {
                    lThumb = numberToCoor(num);
                    ans.append("L");
                } else if (rDistance < lDistance) {
                    rThumb = numberToCoor(num);
                    ans.append("R");
                }
                // 거리가 같으면 주로 사용하는 손으로
                else {
                    if (hand.equals("left")) {
                        lThumb = numberToCoor(num);
                        ans.append("L");
                    } else {
                        rThumb = numberToCoor(num);
                        ans.append("R");
                    }
                }
            }
        }
        return ans.toString();
    }
}