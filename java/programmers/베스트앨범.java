package programmers;

//https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

        Stream<Map.Entry<String, Integer>> sortedGenre = genrePlayMap.entrySet().stream()
                // 오버플로우 방지를 위해, 값 비교에는 Integer와 같은 래퍼 클래스를 써주는게 좋다
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        List<Integer> ans = new ArrayList<>();

        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMusicMap.get(entry.getKey()).stream()
                    // stream의 sorted는 순서가 있는 스트림을 정렬할 때 기존 순서를 유지하는 stable sort이다
                    // 따라서 고유번호에 따른 오름차순 정렬을 따로 해주지 않아도 됨
                    .sorted((e1, e2) -> Integer.compare(e2[1], e1[1]))
                    .limit(2);
            sortedSongs.forEach(song -> ans.add(song[0]));
        });

        return ans.stream().mapToInt(Integer::intValue).toArray();
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