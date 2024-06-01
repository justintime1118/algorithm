package leetcode;

//https://leetcode.com/problems/course-schedule/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> presMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            presMap.putIfAbsent(pre[0], new ArrayList<>());
            presMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> toBeCheckedSet = new HashSet<>();
        Set<Integer> takableSet = new HashSet<>();

        for (Integer course : presMap.keySet()) {
            if (!dfs(course, toBeCheckedSet, presMap, takableSet))
                return false;
        }

        return true;
    }

    public boolean dfs(int course, Set<Integer> toBeCheckedSet, Map<Integer, List<Integer>> presMap,
            Set<Integer> takableSet) {
        // 재귀호출로 불러진 선수과목(course)이 자신을 선수과목으로 지정한 과목(toBeCheckedSet의 원소)을 서로 선수과목으로 가짐
        // 즉, 사이클 존재 -> 수강 불가
        if (toBeCheckedSet.contains(course)) {
            return false;
        }

        // 이미 수강 가능한 것으로 확인된 과목은 바로 true 리턴하여 가지치기
        if (takableSet.contains(course))
            return true;

        // 선수과목이 있는 경우에만 선수과목 별로 dfs
        if (presMap.containsKey(course)) {
            toBeCheckedSet.add(course);
            for (Integer pre : presMap.get(course)) {
                if (!dfs(pre, toBeCheckedSet, presMap, takableSet))
                    return false;
            }
            toBeCheckedSet.remove(course);
        }

        takableSet.add(course);
        return true;
    }
}