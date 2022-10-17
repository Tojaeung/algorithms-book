package BOJ.DP;

import java.util.Scanner;

public class 오르막수_11057번 {
    public static int n, mod = 10007;
    public static long[][] dp = new long[1001][1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 0   1 10 55
        // 1   1 9  45
        // 2   1 8
        // 3   1 7
        // 4   1 6
        // 5   1 5
        // 6   1 4 
        // 7   1 3
        // 8   1 2
        // 9   1 1
        dp[0][1] = dp[1][1] = dp[2][1] = dp[3][1] = dp[4][1] = dp[5][1] = dp[6][1] = dp[7][1] = dp[8][1] = dp[9][1] = 1;

        for (int j = 2; j <= n; j++) {
            for (int i = 0; i < 10; i++) {
                for (int k = i; k < 10; k++) {
                    dp[i][j] += dp[k][j - 1] % mod;
                    dp[i][j] %= mod;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[i][n];
        }
        System.out.println(result % mod);

    }
}
