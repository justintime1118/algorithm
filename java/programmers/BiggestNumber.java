package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String ans = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    return (s2 + s1).compareTo(s1 + s2);
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
        return ans;
    }
}