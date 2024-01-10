package programmers;

import java.util.*;

/**
 * 책에 나온 풀이
 * 나의 풀이와의 차이점
 * - StringTokenizer를 활용
 * - opPriorities를 하드코딩
 * 메인 로직은 거의 유사하나, 전체적으로 코드가 훨씬 간결하다
 */
class Solution {

    private static final String[][] opPriorities = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    };
    
    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for (String[] opPriority: opPriorities) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), opPriority));
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    
    private long calculate(long lhs, long rhs, String op) {
        return switch (op) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    private long calculate(List<String> tokens, String[] opPriority) {
        for (String op : opPriority) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long lhs = Long.valueOf(tokens.get(i - 1));
                    long rhs = Long.valueOf(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.valueOf(tokens.get(0));
    }
    
}
