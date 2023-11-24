import java.util.*;

// https://www.acmicpc.net/problem/12865
// 백준 평범한 배낭 문제

public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 전체 물품개수
		int k = sc.nextInt(); // 제한 무게

		int[] w = new int[n + 1]; // 물품 별 무게. 인덱싱 편의성을 위해 길이를 n + 1로 지정
		int[] v = new int[n + 1]; // 물품 별 가치. 인덱싱 편의성을 위해 길이를 n + 1로 지정
		for (int i = 1; i <= n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		sc.close();

		// dv[물건 종류][무게] = 물건 종류를 고려하여 무게 제한 하에서 가능한 최대 가치의 합
		// 단, dv[0][무게]는 무게제한 하에서 어떤 물건도 넣지 않은 케이스를 의미 (코너케이스 예외처리 생략 용도)
		int[][] dv = new int[n + 1][k + 1];

		// 무게제한에 걸리면, 이전에 구해둔 i번째 물건을 넣지 않은(고려하지 않은) 무게제한 j 하에서 최대 가치의 합을 그대로 가져오고
		// 제한에 걸리지 않으면, i번째 물건을 넣는 경우와 그렇지 않은 경우 사이에서 더 큰 최대 가치의 합을 할당함
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dv[i][j] = (w[i] <= j) ? Math.max(dv[i - 1][j], dv[i - 1][j - w[i]] + v[i]) : dv[i - 1][j];
			}
		}

		System.out.println(dv[n][k]);
	}
}
/*
	테이블을 구할 때, dv 배열을 dv[무게][물건 종류]로 처음에 생각했기 때문에 점화식을 구하는 것에서 어려움을 겪었음
 */