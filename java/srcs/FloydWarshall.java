import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int d[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                d[i][j] = scanner.nextInt();
                if (d[i][j] == 0) d[i][j] = Integer.MAX_VALUE;
            }


        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++) {
                    if (d[i][k] == Integer.MAX_VALUE || d[k][j] == Integer.MAX_VALUE) continue;
                    if (d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];
                }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print(d[i][j] + " ");
            System.out.println();
        }
    }
}