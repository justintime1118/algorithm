//https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        // 중복 검사용 set
        Set<String> usedWords = new HashSet<>();

        String prevWord = words[0]; // 이전에 나온 단어 저장
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            // 이미 나온 단어이거나, 먼저 나온 단어와 끝말이 안이어지는 경우
            if (usedWords.contains(words[i])
                    || prevWord.charAt(prevWord.length() - 1) != words[i].charAt(0))
                return new int[] { (i % n) + 1, (i / n) + 1 };
            // 문제가 없다면 이번 단어 저장 후 다음 단어로 넘어감
            usedWords.add(words[i]);
            prevWord = words[i];
        }

        // 전체 순회 결과 아무 문제가 없었다면 {0, 0} 리턴
        return new int[] { 0, 0 };
    }
}