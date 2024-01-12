package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;

class Solution {

    public int solution(String s) {   
        char[] charArr = s.toCharArray();
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();
        
        for (int i = charArr.length - 1; i >= 0; i--) {
            st1.push(charArr[i]);
        }
        
        while (!st1.empty()) {
            if (st2.empty() || st2.peek() != st1.peek()) {
                st2.push(st1.pop());
            }
            else if (st1.peek() == st2.peek()) {
                st1.pop();
                st2.pop();
            }
        }
        return st2.empty() ? 1 : 0;
    }
}
