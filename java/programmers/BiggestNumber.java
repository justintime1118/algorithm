package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746
import java.util.ArrayList;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> arrlst = new ArrayList<>();
        for (int number : numbers) {
            arrlst.add(String.valueOf(number));
        }
        String[] strArr = arrlst.stream().sorted((s1, s2) -> {
            return (s2 + s1).compareTo(s1 + s2);
        }).toArray(String[]::new);

        String ans = String.join("", strArr);

        char[] charArr = ans.toCharArray();
        for (char c : charArr) {
            if (c != '0')
                return ans;
        }

        return "0";
    }
}