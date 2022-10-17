package BOJ.DP;

import java.util.Scanner;

public class 동물원_1309번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mod = 9901;

        // 사자를 한마리도 배치하지 않는 경우도 하나의 경우이다.
        // [i][0] 사자를 배치하지 않는 경우 
        // [i][1] 사자를 (i,1)에 배치한 경우 
        // [i][2] 사자를 (i,2)에 배치한 경우
        long[][] dp = new long[n + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += dp[n][i];
        }
        System.out.println(result % mod);

    }
}
