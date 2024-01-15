package programmers;

// 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64064

import java.util.*;
import java.util.regex.*;

class Solution {
    
    HashSet<HashSet<String>> ans = new HashSet<>();
    
    public int solution(String[] userId, String[] bannedId) {
        HashSet<String>[] mappedIdSetArr = new HashSet[bannedId.length];
        
        for (int i = 0; i < bannedId.length; i++) {
            mappedIdSetArr[i] = getMappedIdSet(bannedId[i], userId);
        }
        
        dfs(0, mappedIdSetArr, new HashSet<String>());
        
        return ans.size();
    }
    
    // 백트래킹 방식으로 모든 제재 아이디 목록을 뽑아내는 메서드
    // 마지막 깊이에 도달하면 ans.add()로 제재 아이디 목록이 들어있는 set을 ans에 추가
    public void dfs(int depth, HashSet<String>[] mappedIdSetArr, HashSet<String> curSet) {
        if (depth == mappedIdSetArr.length) {
            ans.add(new HashSet<String>(curSet));
            return;
        }
        
        // 제재 아이디 목록 세트 배열[현재 깊이]에서 값을 하나씩 꺼내 curSet에 넣고 깊이를 하나 더해서 재귀 호출
        // 이미 curSet에 들어간 id이면 재귀호출을 하지 않고 넘어감
        for (String id : mappedIdSetArr[depth]) {
            if (curSet.contains(id)) {
                continue;
            }
            curSet.add(id);
            dfs(depth + 1, mappedIdSetArr, curSet);
            curSet.remove(id);
        }
    }
    
    // userId의 원소 중 전달받은 제재 아이디 패턴(idPattern)에 매핑되는 것들을 원소로 갖는 Set을 만들어서 반환
    public HashSet<String> getMappedIdSet(String idPattern, String[] userId) {
        String patternString = idPattern.replace("*", ".");
        
        HashSet<String> set = new HashSet<>();
        
        for (String id : userId) {
            if (Pattern.matches(patternString, id))
                set.add(id);
        }
        return set;
    }
}
/*



 */