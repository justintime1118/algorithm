package programmers;

// 코딩테스트에서 만큼은, 로직의 정확성과 구현의 편의성이 우선이다. 최적화와 깔끔한 코드는 그 이후에 고려할 사항
class Solution {
    
    private static final int LEN = 5;
    private static final int[] dx = {0, 1, 0, -1}; // 위 오른쪽 아래 왼쪽
    private static final int[] dy = {-1, 0, 1, 0}; // 위 오른쪽 아래 왼쪽
    
    public int[] solution(String[][] places) {
    
        int[] ans = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            // 문자 접근을 용이하게 하기 위해 String[]를 char[][]로 변환
            char[][] charArr = new char[LEN][LEN];
            for (int j = 0; j < LEN; j++) {
                charArr[j] = places[i][j].toCharArray();
            }
            ans[i] = isDistanced(charArr) ? 1 : 0;
        }
        return ans;        
    }

    public boolean isDistanced(char[][] place) {

        // 대기실의 모든 자리를 탐색
        for (int y = 0; y < LEN; y++) {
            for (int x = 0; x < LEN; x++) {
                if (place[y][x] != 'P')
                    continue;
                if (!isDistanced(place, x, y))
                    return false;
            }
        }
        return true;
    }
    
    public boolean isDistanced(char[][] place, int x, int y) {
        
        for (int dir = 0; dir < 4; dir++) {
            int adjX = x + dx[dir];
            int adjY = y + dy[dir];
            if (!(0 <= adjX && adjX < LEN && 0 <= adjY && adjY < LEN)) {
                continue;
            }

            // 인접한 칸에 응시자가 있으면 바로 return
            if (place[adjY][adjX] == 'P')
                return false;

            // 인접한 칸이 비어있으면 그쪽으로 한칸 깊이 들어가서 검사
            if (place[adjY][adjX] == 'O') {
                for (int deepDir = 0; deepDir < 4; deepDir++) {
                    // 한칸 더 들어가는 동안 이미 지나온 방향은 검사 대상이 아님
                    if ((deepDir + 2) % 4 == dir)
                        continue;

                    int deepAdjX = adjX + dx[deepDir];
                    int deepAdjY = adjY + dy[deepDir];
                    if (0 <= deepAdjX && deepAdjX < LEN
                        && 0 <= deepAdjY && deepAdjY < LEN
                        && place[deepAdjY][deepAdjX] == 'P') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
/*
계속 정확도 83.5 %로 틀렸던 코드
로직 자체에 오류가 있었다기 보다 구현 과정에서 실수를 범했고 그걸 발견하지 못했다.
마지막 부분에 왼쪽 하단 대각선 검사할 때 아래처럼 고쳤어야 함
if (0 <= x - 1 && 0 <= y - 1 && charArr[y - 1][x - 1] == 'P')
    -> if (0 <= x - 1 && y + 1 < 5 && charArr[y + 1][x - 1] == 'P')
class Solution {
    private final int LEN = 5;
    
    public int[] solution(String[][] places) {
    
        int[] ans = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            ans[i] = isDistanced(places[i]) ? 1 : 0;
        }    
        return ans;        
    }
    
    public boolean isDistanced(String[] place) {
        
        // 문자 접근을 용이하게 하기 위해 String[]를 char[][]로 변환
        char[][] charArr = new char[LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            charArr[i] = place[i].toCharArray();
        }
        
        // 대기실의 모든 자리를 탐색
        for (int y = 0; y < LEN; y++) {
            for (int x = 0; x < LEN; x++) {
                if (charArr[y][x] != 'P')
                    continue;
                
                // 오른쪽 or 아래쪽 인접한 자리에 앉은 사람이 있는지 검사
                if ((x + 1 < 5 && charArr[y][x + 1] == 'P')) {
                    return false;
                }
                if (y + 1 < 5 && charArr[y + 1][x] == 'P') {
                    return false;
                }
                
                // 오른쪽 or 아래쪽 두칸 떨어진 자리에 앉은 사람이 있고 && 그 사이가 비어있는지 검사
                if (x + 2 < 5 && charArr[y][x + 2] == 'P' && charArr[y][x + 1] != 'X') {
                    return false;
                }
                if (y + 2 < 5 && charArr[y + 2][x] == 'P' && charArr[y + 1][x] != 'X') {
                    return false;
                }
                
                // 오른쪽 하단 대각선 자리에 앉은 사람이 있고 && 그 사이가 비어있는지 검사
                if (x + 1 < 5 && y + 1 < 5 && charArr[y + 1][x + 1] == 'P') {
                    if (charArr[y + 1][x] != 'X' || charArr[y][x + 1] != 'X')
                        return false;
                }
                // 왼쪽 하단 대각선 자리에 앉은 사람이 있고 && 그 사이가 비어있는지 검사
                // 여기에 y를 1을 뺄 것이 아니라 더해줘야 하는데 여기 실수한 걸 발견 못했다..
                if (0 <= x - 1 && 0 <= y - 1 && charArr[y - 1][x - 1] == 'P') {
                    if (charArr[y - 1][x] != 'X' || charArr[y][x - 1] != 'X')
                        return false;
                }
            }
        }
        
        return true;
    }
}
*/