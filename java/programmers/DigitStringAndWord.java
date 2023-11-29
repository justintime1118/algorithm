package programmers;

import java.util.*;

class Solution {
    public int solution(String s) {
        
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuffer ans = new StringBuffer(s.length()); // 정답 return 용도
        StringBuffer buffer = new StringBuffer(); // 임시 buffer 용도
        for (char c : s.toCharArray()) {
            // 숫자면 그냥 append하고 다음 문자로 넘어간다
            if (Character.isDigit(c)) {
                ans.append(c);
            }
            // 문자면 영단어가 성립될 때까지 읽어들이며 buffer에 append
            // 영단어가 성립되면 숫자로 바꿔서 ans에 append 후 buffer 초기화
            else {
                buffer.append(c);
                if (map.containsKey(buffer.toString())) {
                    ans.append(map.get(buffer.toString()));
                    buffer.delete(0, buffer.length());
                }
            }
        }
        
        return Integer.valueOf(ans.toString());
    }
}

/*
교재풀이 (시간복잡도 측면에서 비효율적이지만 충분히 제한조건을 통과할 수 있고, 무엇보다 풀이가 간략함)
public class Solution {
    private static final String[] words = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
    };

    public int solution(String s) {
        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
*/