package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int maxMusicNum = genres.length - 1;
        Map<String, Integer> genrePlayMap = new HashMap<>();
        Map<String, List<int[]>> genreMusicMap = new HashMap<>();

        for (int i = 0; i <= maxMusicNum; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);

            genreMusicMap.putIfAbsent(genres[i], new ArrayList<>());
            genreMusicMap.get(genres[i]).add(new int[] { i, plays[i] });
        }

        List<String> sortedGenrePlayList = genrePlayMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> ans = new ArrayList<>();

        for (String genre : sortedGenrePlayList) {
            List<Integer> sortedMusicNumList = genreMusicMap.get(genre).stream()
                    .sorted((e1, e2) -> {
                        if (e1[1] == e2[1])
                            return e1[0] - e2[0];
                        else
                            return e2[1] - e1[1];
                    })
                    .map(e -> e[0])
                    .limit(2)
                    .collect(Collectors.toList());
            ans.addAll(sortedMusicNumList);
        }

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
/*
 * <부품>
 * 장르 별 총 재생횟수
 * 장르 별 속한 곡 목록(재생횟수 내림차순 정렬, 횟수가 같으면 고유 번호 오름차순 정렬)
 * 
 * Map<String, Integer> genrePlayMap <장르명, 총 재생횟수>
 * Map<String, List<int[]>> genreMusicMap <장르명, [곡 고유번호, 재생횟수]>
 */

/*
 * <로직>
 * genres와 plays를 순회하며 부품 두개 만들어 냄
 * 
 * genrePlayMap의 entrySet을 뽑아서 value를 기준으로 내림차순 정렬.
 * 재생횟수가 많은 장르부터 차례대로 그 안에서 가장 많이 재생된 최대 두곡씩을 뽑아내면 됨
 */