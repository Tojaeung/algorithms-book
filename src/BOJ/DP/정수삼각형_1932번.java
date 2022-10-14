package BOJ.DP;


import java.util.Scanner;

public class 정수삼각형_1932번 {
    public static int n;

    public static int dp[][] = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                dp[i - 1][j] = Math.max(dp[i - 1][j] + dp[i][j], dp[i - 1][j] + dp[i][j + 1]);
            }
        }

        System.out.println(dp[0][0]);

    }
}
