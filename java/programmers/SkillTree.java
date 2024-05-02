package programmers;

//문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java#

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String skillOrders, String[] skillTrees) {
        int ans = skillTrees.length;
        for (String skillTree : skillTrees) {
            if (!checkSkillTree(skillTree, skillOrders)) {
                ans--;
            }
        }
        return ans;
    }

    public boolean checkSkillTree(String skillTree, String skillOrders) {
        List<Character> preSkills = new ArrayList<>();

        for (char skill : skillTree.toCharArray()) {
            // 선행스킬 조건이 없는 스킬은 skip
            if (skillOrders.indexOf(skill) == -1)
                continue;
            // 선행스킬 조건이 있다면, 선행 조건을 만족하는지 preSkills를 통해 확인
            if (!checkPreSkills(skill, skillOrders, preSkills)) {
                return false;
            }
            // 선행스킬 조건이 있고, 조건을 만족하는 선행스킬들은 preSkills에 담아줌
            preSkills.add(skill);
        }
        return true;
    }

    public boolean checkPreSkills(char skill, String skillOrders, List<Character> preSkills) {
        int curSkillIdx = skillOrders.indexOf(skill);
        // 첫번째 선행스킬은 그에 앞선 선행스킬이 없으므로 true
        if (curSkillIdx == 0)
            return true;

        // 바로 직전에 들어온 선행스킬이 순서 상 현 skill의 바로 앞 선행스킬과 같은지만 확인해주면 됨
        if (preSkills.size() < curSkillIdx
                || skillOrders.charAt(curSkillIdx - 1) != preSkills.get(curSkillIdx - 1))
            return false;
        return true;
    }
}