package programmers;

class Solution {
    public int solution(int n, int a, int b) {
        int ans = 1;

        while (true) {
            // 작은 번호가 홀수이고 큰 번호가 짝수이면서 서로 연속된 수이면 맞붙었다는 뜻
            if (Math.min(a, b) % 2 == 1 && Math.max(a, b) % 2 == 0
                    && Math.max(a, b) - Math.min(a, b) == 1)
                break;

            // 맞붙지 않았으면 라운드 진행
            ans++;

            // a와 b에 다음 번호를 부여
            // 현재 짝수이면 그대로 2로 나눠주면 다음 번호가 되고
            // 현재 홀수이면 2로 나눈 뒤 1을 더해줘야 다음 번호가 된다
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;
        }
        return ans;
    }
}
