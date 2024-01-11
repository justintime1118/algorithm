package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;

class Solution {
    
    private static int numLen;
    private static boolean[] isUsed;
    
    public int solution(String numbers) {
        numLen = numbers.length();
        isUsed = new boolean[numLen];
        
        HashSet<Integer> primeSet = new HashSet<>();
        backTrack(0, "", isUsed, numbers, primeSet);
        return primeSet.size();
    }
    
    public void backTrack(int depth, String number, boolean[] isUsed, String numbers, HashSet<Integer> primeSet) {
        
        if (depth > numbers.length())
            return;
        
        if (!number.equals("")) {
            int numberInt = Integer.valueOf(number);
            if (isPrime(numberInt) == true) {
                primeSet.add(numberInt);
            }
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (isUsed[i] == true)
                continue;
            isUsed[i] = true;
            backTrack(depth + 1, number + numbers.charAt(i), isUsed, numbers, primeSet);
            isUsed[i] = false;
        }
    }
    
    public boolean isPrime(int number) {
        if (number == 0 || number == 1)
            return false;
        
        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}