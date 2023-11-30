package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72410

class Solution {

    public String solution(String new_id) {
        
        String ans = new_id.toLowerCase(); // 1단계
        ans = ans.replaceAll("[^a-z0-9\\-_.]", ""); // 2단계
        ans = ans.replaceAll("\\.+", "."); // 3단계
        ans = ans.replaceAll("^\\.|\\.$", ""); // 4단계
        ans = ans.length() == 0 ? "a" : ans; // 5단계
        // 6단계
        if (ans.length() >= 16) {
            ans = ans.substring(0, 15);
            ans = ans.replaceAll("\\.$", "");
        }
        // 7단계
        while (ans.length() < 3) {
            ans += ans.charAt(ans.length() - 1);
        }
        return ans;
    }
    
}