import java.util.*;

// https://www.acmicpc.net/problem/12865
// 백준 평범한 배낭 문제

// 아래는 코드그라운드 노트 예시 코드
public class Knapsack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 물건의 갯수
        int k = sc.nextInt(); // 무게 제한 k
        int[] v = new int[n + 1]; // 물건의 가치 배열
        int[] w = new int[n + 1]; // 물건의 무게 배열
        for (int i = 1; i <= n; i++) { // 배열 초기화. d[0][j]는 따로 초기화 작업이 없기 때문에 그냥 0이 들어있다
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] d = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
			// System.out.print("\n");
            for (int j = 0; j <= k; j++) {
				// System.out.println("w[i] = " + w[i] + ", v[i] = " + v[i]);
                if (j < w[i])// w[i]가 무게 제한 j를 초과한다. i번째 물건은 넣지 않는다.
                    d[i][j] = d[i - 1][j];
                else if (d[i - 1][j - w[i]] + v[i] > d[i - 1][j]) // w[i]가 j를 초과하지 않고, i를 넣었을 때의 가치가 더 크므로 넣을 때의 가치로 정함
                    d[i][j] = d[i - 1][j - w[i]] + v[i];
                else // w[i]가 j를 초과하지 않지만, 안 넣는 것이 더 가치가 크므로 안 넣을 때의 가치를 그대로 가져온다.
                    d[i][j] = d[i - 1][j];
				// System.out.printf("d[%d][%d] = %d\n", i, j, d[i][j]);
            }
        }
        System.out.println(d[n][k]);
    }
}

/*
<실행한 결과값>
jiyoo@Justins-MacBook-Air algorithm % java Knapsack
4  7
13  6
8  4
6  3
12  5

d[1][0] = 0
d[1][1] = 0
d[1][2] = 0
d[1][3] = 0
d[1][4] = 0
d[1][5] = 0
d[1][6] = 13
d[1][7] = 13

d[2][0] = 0
d[2][1] = 0
d[2][2] = 0
d[2][3] = 0
d[2][4] = 8
d[2][5] = 8
d[2][6] = 13
d[2][7] = 13

d[3][0] = 0
d[3][1] = 0
d[3][2] = 0
d[3][3] = 6
d[3][4] = 8
d[3][5] = 8
d[3][6] = 13
d[3][7] = 14

d[4][0] = 0
d[4][1] = 0
d[4][2] = 0
d[4][3] = 6
d[4][4] = 8
d[4][5] = 12
d[4][6] = 13
d[4][7] = 14

최대 가치 = 14
*/