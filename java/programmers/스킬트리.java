package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/49993#fnref1

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String preSkill, String[] skillTrees) {
        // 선행 스킬 여부를 검사하기 위한 set
        Set<Character> preSkills = new HashSet<>();
        for (char ps : preSkill.toCharArray())
            preSkills.add(ps);

        int ans = 0;
        for (String st : skillTrees) {
            // 스킬트리에 포함되지 않은 스킬을 삭제
            String trimmedSt = removeNonPreSkills(st, preSkills);

            // 선행스킬을 잘 지키는지 검사
            if (preSkill.substring(0, trimmedSt.length()).equals(trimmedSt)) {
                ans++;
            }
        }

        return ans;
    }

    public String removeNonPreSkills(String st, Set<Character> preSkills) {
        StringBuffer sb = new StringBuffer();

        for (char s : st.toCharArray()) {
            if (preSkills.contains(s))
                sb.append(s);
        }

        return new String(sb);
    }
}