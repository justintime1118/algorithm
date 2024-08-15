import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/49994

class Solution {

    static class Coor {
        int x;
        int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Coor otherCoor = (Coor) o;
            return (this.x == otherCoor.x && this.y == otherCoor.y) ? true : false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public int solution(String dirs) {
        // 맵의 범위
        final int MIN_X = -5;
        final int MIN_Y = -5;
        final int MAX_X = 5;
        final int MAX_Y = 5;

        // 지나간 경로를 기록하기 위한 map
        Map<Coor, Set<Coor>> visited = new HashMap<>();

        // 정답을 기록할 변수
        int ans = 0;

        // 현재 좌표 초기화
        Coor curCoor = new Coor(0, 0);

        // 주어진 명령어에 따라 이동
        for (char c : dirs.toCharArray()) {
            // 다음 좌표 계산
            Coor nextCoor = new Coor(curCoor.x, curCoor.y);
            if (c == 'U') {
                nextCoor.y++;
            } else if (c == 'D') {
                nextCoor.y--;
            } else if (c == 'R') {
                nextCoor.x++;
            } else {
                nextCoor.x--;
            }

            // 맵의 범위를 벗어나면 무시
            if (nextCoor.x < MIN_X || MAX_X < nextCoor.x
                    || nextCoor.y < MIN_Y || MAX_Y < nextCoor.y) {
                continue;
            }

            // 현재좌표와 다음좌표, visited를 이용해서 지나온 길인지 아닌지 확인
            visited.putIfAbsent(curCoor, new HashSet<>());
            visited.putIfAbsent(nextCoor, new HashSet<>());
            if (!visited.get(curCoor).contains(nextCoor)
                    && !visited.get(nextCoor).contains(curCoor)) {
                ans++;
                visited.get(curCoor).add(nextCoor);
            }
            curCoor = nextCoor;
        }

        return ans;
    }
}