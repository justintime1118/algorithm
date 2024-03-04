import java.util.*;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12917

class Solution {
    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .collect(StringBuffer::new, // supplier
                         StringBuffer::appendCodePoint, // accumulator
                         StringBuffer::append) // combiner(멀티스레드 환경에서 사용되는 파라미터)
                .toString();
    }
}