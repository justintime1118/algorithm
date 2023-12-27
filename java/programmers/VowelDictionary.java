package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512

// 정답 맞힌 코드

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

// 이하 삽질한 코드
/*
import java.util.*;

class Solution {
    
    int order = 1;
    String finalWord;
    
    Map<Integer, String> alphaMap = new HashMap<>();
    
    public int solution(String word) {
        
        alphaMap.put(0, "A");
        alphaMap.put(1, "E");
        alphaMap.put(2, "I");
        alphaMap.put(3, "O");
        alphaMap.put(4, "U");
        
        vowelDict("A", 'A', word, 1);
        System.out.println("finalWord == " + finalWord);
        return order;
    }
    
    // 메서드 파라미터로 상태 정의
    // 아래 재귀 규칙과 아귀가 맞아야 함
    public void vowelDict(String currentWord, int currentAlpha, String word, int depth) {
        if (order > 30)
            return;
        // base condition
        if (word.equals(currentWord)) {
            finalWord = currentWord;
            return;
        }
        if (depth > 5) {
            return;
        }
        
        System.out.println(currentWord);
        
        // recursive logic
        if (!word.equals(currentWord)) {
            // 1. 자릿수 하나 키우고 새로 생겨난 자리에 A 채우기
            vowelDict(new String(currentWord + "A"), 0, word, depth + 1);
            order++;
            
            // 2. 현재 위치에서 다음 알파벳으로 올리기
            String nextWord = currentWord.substring(currentWord.length() - 1);
            nextWord += alphaMap.get((currentAlpha + 1) % 5);
            vowelDict(nextWord, (currentAlpha + 1) % 5, word, depth);
            order++;
        }
    }
}
*/