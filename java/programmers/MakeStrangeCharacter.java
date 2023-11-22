package programmers;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12930

class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        
        char[] arr = s.toCharArray();
        int i = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == ' ') {
                sb.append(arr[i]);
                i++;
            }
            startIdx = i;
            endIdx = i;
            while(i < arr.length && arr[i] != ' ') {
                endIdx++;
                i++;
            }
            sb.append(changeCase(s.substring(startIdx, endIdx)));
        }
        return sb.toString();
    }
    
    public String changeCase(String s) {
        StringBuffer result = new StringBuffer(s.length());
        
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                result.append(Character.toUpperCase(arr[i]));
            else
                result.append(Character.toLowerCase(arr[i]));
        }
        
        return result.toString();
    }
}

/*
// 책에 나온 풀이
class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                toUpper = true;
            }
            else {
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                }
                else {
                    sb.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }
        return sb.toString();
    }
}
*/