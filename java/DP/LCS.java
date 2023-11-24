import java.util.*;

public class LCS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int la = sc.nextInt();
        int lb = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        sc.close();

		// 테이블을 머릿속으로 상상하면서 보면 좀 더 이해가 쉽다
        int lcs[][] = new int[la + 1][lb + 1];
        for (int i = 1; i <= la; i++) {
            for (int j = 1; j <= lb; j++) {
				// 원소 둘이 동일하다면 직전 LCS 값에 1을 더해주면 된다.
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
				// 원소 둘이 다르다면, 직전 LCS 값 중 더 큰 것을 가져와서 넣어준다.
                else {
                    if (lcs[i - 1][j] < lcs[i][j - 1]) {
                        lcs[i][j] = lcs[i][j - 1];
                    }
                    else {
                        lcs[i][j] = lcs[i - 1][j];
                    }
                }
            }
        }
        System.out.println(lcs[la][lb]);
    }
}

//https://velog.io/@emplam27/알고리즘-그림으로-알아보는-LCS-알고리즘-Longest-Common-Substring와-Longest-Common-Subsequence