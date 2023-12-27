package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512

// 교재에 수록된 보다 최적화된 코드

import java.util.*;

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();

    private void generate(String word, List<String> words) {
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
}

// 내가 푼 정답 코드
/*
class Solution {

    int order;
    boolean finished;

    public int solution(String word) {
        vowelDict(0, "", word);
        return order;
    }

    public void vowelDict(int depth, String currentString, String word) {
        
        // base condition
        if (word.equals(currentString)) {
            finished = true;
        }
        if (depth == 6) {
            return;
        }

        // recursive logic
        if (!finished) {
            order++;
            // 순차적으로 알파벳 채우기
            vowelDict(depth + 1, new String(currentString + "A"), word);
            vowelDict(depth + 1, new String(currentString + "E"), word);
            vowelDict(depth + 1, new String(currentString + "I"), word);
            vowelDict(depth + 1, new String(currentString + "O"), word);
            vowelDict(depth + 1, new String(currentString + "U"), word);
        }
    }
}
*/