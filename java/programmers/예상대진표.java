package programmers;

class Solution {
    public int solution(int n, int a, int b) {
        int ans;

        // 둘이 이겨서 올라간 번호가 서로 같다면 둘이 맞붙었다는 뜻
        for (ans = 0; a != b; ans++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return ans;
    }
}
