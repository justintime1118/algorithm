package programmers;

import java.util.*;

class Solution {
    
    public long solution(String expression) {
        // expression을 파싱해서 피연산자 리스트와 연산자 리스트에 나눠 담기
        ArrayList<String> operandList = new ArrayList<>(Arrays.asList(expression.split("[-*+]")));
        ArrayList<String> operatorList = new ArrayList<>(Arrays.asList(expression.split("[0-9]+")));
        operatorList.remove(0); // 왜 맨 앞에 빈 문자열이 원소로 하나 들어갈까?

        String[] operators = {"+", "-", "*"};
        String[] seq = new String[3];
        long ans = 0;
        
        // 연산자 순열을 구한 뒤, 연산 메소드 호출
        for (int i = 0; i < 3; i++) {
            seq[0] = operators[i];
            for (int j = 0; j < 3; j++) {
                if (j == i)
                    continue;
                seq[1] = operators[j];
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j)
                        continue;
                    seq[2] = operators[k];
                    // 연산 메소드 호출
                    ans = Math.max(Math.abs(calculate(seq
                                                      , new ArrayList<String>(operandList)
                                                      , new ArrayList<String>(operatorList)))
                                   , ans);
                }
            }
        }
        return ans;
    }
    
    // 인자로 받은 연산자 배열 우선순위대로 계산된 최종 결과값을 반환
    public long calculate(String[] operators, ArrayList<String> operandList, ArrayList<String> operatorList) {
        for (int i = 0; i < 3; i++) {
            calculate(operators[i], operandList, operatorList);
        }
        return Long.valueOf(operandList.get(0));
    }
    
    // 인자로 받은 연산자를 연산한 중간 결과값을 각각의 리스트에 반영
    public void calculate(String operator, ArrayList<String> operandList, ArrayList<String> operatorList) {
        int operatorIdx = 0;
        int operandIdx = 0;
        long result = 0;
        while (0 < operatorList.size() && operatorIdx < operatorList.size()) {
            if (!operatorList.get(operatorIdx).equals(operator)) {
                operatorIdx++;
                operandIdx++;
            }
            else {
                result = 0;
                result += Long.valueOf(operandList.remove(operandIdx));
                if (operator.equals("+")) {
                    result += Long.valueOf(operandList.remove(operandIdx));
                }
                else if (operator.equals("-")) {
                    result -= Long.valueOf(operandList.remove(operandIdx));
                }
                else if (operator.equals("*")) {
                    result *= Long.valueOf(operandList.remove(operandIdx));
                }
                operandList.add(operandIdx, String.valueOf(result));
                operatorList.remove(operatorIdx);
            }
        }
    }
}
