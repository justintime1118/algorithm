package boj;

//https://www.acmicpc.net/problem/12865

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력값 받아서 저장
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] items = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }

        // dp table 생성 및 초기화
        int[][] d = new int[n + 1][k + 1]; // 길이 여유분을 둬서 인덱스에 물건번호와 무게를 일치시킴
        // 행 초기화
        for (int i = 0; i <= k; i++) {
            d[0][i] = 0;
        }
        // 열 초기화
        for (int i = 0; i <= n; i++) {
            d[i][0] = 0;
        }

        // 점화식 따라서 테이블 채우기
        for (int i = 1; i <= n; i++) {
            int weight = items[i][0];
            int value = items[i][1];
            for (int j = 1; j <= k; j++) {
                d[i][j] = j < weight // 현재 무게 제한에서 들어갈 수 없는 물건이면
                        ? d[i - 1][j] // 이전 물건까지로 구한 최대 가치를 넣음
                        // 이전 물건으로 구한 최대 가치와 현 물건을 포함한 최대 가치를 비교
                        : Math.max(d[i - 1][j], d[i - 1][j - weight] + value);
            }
        }

        // 테이블 마지막 행의 마지막 열이 정답이 됨
        System.out.println(d[n][k]);
    }
}
