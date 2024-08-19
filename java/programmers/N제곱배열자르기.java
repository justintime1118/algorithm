package programmers;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left + 1;
        int[] ans = new int[len];

        for (int i = 0; i < ans.length; i++) {
            long idx = left + i;
            // 값이 채워지는 것은 0부터가 아닌 1부터이므로 1을 더해줌
            long row = idx / n + 1;
            long col = idx % n + 1;

            ans[i] = col <= row ? (int) row : (int) col;
        }

        return ans;
    }
}
/*
 * 명확한 규칙성을 가지고 숫자가 채워지므로, 특정 인덱스에 대한 값을 계산해낼 수 있다
 */
