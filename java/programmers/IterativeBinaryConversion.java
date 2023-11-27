package programmers;

// 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/70129

class Solution {

    public int[] solution(String s) {
        
        int binaryConversionCnt = 0;
        int removedZeroCnt = 0;
        
        while (!s.equals("1")) {
            int zeroCnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroCnt++;
                }
            }
            binaryConversionCnt++;
            removedZeroCnt += zeroCnt;
            s = Integer.toString(s.length() - zeroCnt, 2);
        }
        return new int[] {binaryConversionCnt, removedZeroCnt};
    }
}