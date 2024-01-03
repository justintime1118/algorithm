package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842

// 전에 풀어 둔 코드
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        int total = brown + yellow;
        int width = 0;
        int height = 0;
        // brown + yellow를 나머지 없이 딱 나눌 수 있는 수를 3부터 시작해서 구한다.
        // 그러면 세로 * 가로 길이가 될 수 있는 쌍이 나온다.
        // 걔네가 주어진 brown과 yellow가 나오는 애들인지 확인하면 됨
        
        for (int i = 3; total / i >= i; i++) {
            if (total % i != 0)
                continue ;
            height = i;
            width = total / i;
            if (check(width, height, yellow) == true) {
                ans[0] = width;
                ans[1] = height;
                break ;
            }
        }
        return ans;
    }
    
    public boolean check(int width, int height, int yellow) {
        int checkYellow = (width - 2) * (height - 2);

        // 최종확인
        if (checkYellow == yellow)
            return (true);
        else
            return (false);
    }
}