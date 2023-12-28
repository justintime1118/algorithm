package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution {
    
    int depth;
    int cnt;
    
    public int solution(int[] numbers, int target) {
        depth = numbers.length;
        
        dfs(0, 0, numbers, target);
        
        return cnt;
    }
    
    public void dfs(int number, int idx, int[] numbers, int target) {
        if (idx == depth) {
            if (number == target)
                cnt++;
            return;
        }
        
        dfs(number + numbers[idx], idx + 1, numbers, target);
        dfs(number - numbers[idx], idx + 1, numbers, target);
        
    }
}
