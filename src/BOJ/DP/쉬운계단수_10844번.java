package BOJ.DP;

import java.util.Scanner;

public class 쉬운계단수_10844번 {
    public static int n, mod = 1000000000;

    // 나눠주는 값이 크므로 long 자료형 사용
    public static long[][] dp = new long[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 끝자리가 0이 나오는경우 1밖에 올 수 없다.
        // 끝자리가 9가 나오는경우 8밖에 올 수 없다.

        //      1 2 3 4 5 6 7 8 9     -----> n 자리
        // 0    0 
        // 1    1
        // 2    1
        // 3    1
        // 4    1
        // 5    1
        // 6    1
        // 7    1
        // 8    1
        // 9    1

        for (int i = 1; i <= 9; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                // 끝자리가 0이 나오는경우 1밖에 올 수 없다.
                if (j == 0) dp[j][i] = dp[j + 1][i - 1] % mod;
                    // 끝자리가 9가 나오는경우 8밖에 올 수 없다.
                else if (j == 9) dp[j][i] = dp[j - 1][i - 1] % mod;
                else dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % mod;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[i][n];
        }

        System.out.println(result % mod);   // 모듈러연산


        // 근거없는 점화식으로 문제풀었던 흔적..
        // dp[0] = 0;  // 9 - 0
        // dp[1] = 1;  // 18 - 1
        // for (int i = 2; i < n; i++) {
        //     dp[i] = (i + (dp[i - 1] * 2));
        // }
        //
        // long result = ((9 * (long) Math.pow(2, n - 1)) % mod) - (dp[n - 1] % mod);

        // System.out.println(result % mod);
    }
}
