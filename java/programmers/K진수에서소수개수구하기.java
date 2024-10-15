package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335

class Solution {
    public int solution(int n, int k) {
        int ans = 0;

        String num = Integer.toString(n, k);
        for (String s : num.split("[0]+")) {
            // 연속된 0이 빈 문자열로 변환될 수 있음에 주의
            if (s.equals(""))
                continue;
            // s가 의미하는 숫자가 int 타입을 넘어서는 경우가 가능함에 주의!!!!
            if (isPrime(Long.valueOf(s))) {
                ans++;
            }
        }

        return ans;
    }

    public boolean isPrime(long num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
/*
 * <자릿수 문제>
 * n의 최댓값은 백만
 * 백만은 2^20 정도이고, 따라서 2진수로 표현하면 자릿수가 20비트 정도 됨
 * 근데 이 이진수를 다시 십진수로 읽으면 10^20이 되므로, 1000조가 된다
 * int의 범위는 대략 20억까지 이고, long의 범위는 대략 9000조이기에
 * 해당 문자열을 int로 변환하려고 하면 런타임 에러가 발생하고, long으로 하면 잘 작동하게 됨
 */
