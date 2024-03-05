package leetcode;

import java.util.ArrayList;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 문자 로그(정렬될 로그)와 숫자 로그로 분류
        ArrayList<String> letterLogs = new ArrayList<>(logs.length);
        ArrayList<String> digitLogs = new ArrayList<>(logs.length);

        for (String log : logs) {
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }

        // 문자 로그 정렬
        letterLogs.sort((s1, s2) -> {
            String[] s1Split = s1.split(" ", 2);
            String[] s2Split = s2.split(" ", 2);
            int logComparison = s1Split[1].compareTo(s2Split[1]);
            // 문자가 같으면 식별자로 정렬
            if (logComparison == 0) {
                return s1Split[0].compareTo(s2Split[0]);
            }
            // 문자가 다르면 문자로 정렬
            else {
                return s1Split[1].compareTo(s2Split[1]);
            }
        });

        // 정렬된 문자로그 뒤에 숫자로그를 순서대로 넣고 리턴
        letterLogs.addAll(digitLogs);

        return letterLogs.toArray(new String[0]);
    }
}