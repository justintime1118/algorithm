package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;

class Solution {
    
    public int solution(String numbers) {
        HashSet<Integer> primeSet = new HashSet<>();
        int[] numArray = numbers.chars().map(c -> c- '0').toArray();
        getPrime(0, numArray, new boolean[numArray.length], primeSet);
        return primeSet.size();
    }
    
    public void getPrime(int currentNum, int[] numArray, boolean[] isUsed, HashSet<Integer> primeSet) {

        if (isPrime(currentNum) == true) {
            primeSet.add(currentNum);
        }
        
        for (int i = 0; i < numArray.length; i++) {
            if (isUsed[i])
                continue;
            int nextNum = currentNum * 10 + numArray[i];
            isUsed[i] = true;
            getPrime(nextNum, numArray, isUsed, primeSet);
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