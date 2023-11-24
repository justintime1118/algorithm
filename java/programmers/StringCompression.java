package programmers;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60057

class Solution {
    public int solution(String s) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            ans = Math.min(ans, calCompressedLen(s, i));
        }
        return ans;
    }

    public int calCompressedLen(String s, int unitLen) {
        StringBuffer sb = new StringBuffer();
        
        int beginIdx = 0;
        int endIdx = beginIdx + unitLen; // substring에서 endIdx는 포함하지 않음
        int compressCnt = 0; // 압축된 횟수
        String prevSubstr = ""; // 이전에 substring한 값
        String curSubstr = ""; // 현재 substring한 값
        
        while (endIdx <= s.length()) {
            curSubstr = s.substring(beginIdx, endIdx);
            
            // 이전과 중복되는 문자열이면 총 중복 횟수(압축 횟수)를 늘린다
            if (curSubstr.equals(prevSubstr)) {
                compressCnt++;
            }
            // 이전 문자열과 중복되지 않는다면
            else {
                // 이전에 중복된 적이 있어서 압축이 발생했다면 그것을 반영해서 append
                if (compressCnt > 0) {
                    sb.append(String.valueOf(compressCnt + 1) + prevSubstr);
                }
                // 압축이 발생하지 않으면 그대로 append
                else {
                    sb.append(prevSubstr);
                }
                compressCnt = 0;
                prevSubstr = curSubstr;
            }
            beginIdx = endIdx;
            endIdx += unitLen;
            
        }
        
        // unitLen으로 잘랐을 때 마지막 단위를 포함하여 루프 내에서 미처리된 부분 처리
        if (compressCnt > 0) {
            sb.append(compressCnt + 1);
        }
        sb.append(prevSubstr);
        
        // unitLen 단위로 잘랐을 때 끝에 남는 문자열 처리
        sb.append(s.substring(beginIdx, s.length()));

        return sb.length();
    }
}
