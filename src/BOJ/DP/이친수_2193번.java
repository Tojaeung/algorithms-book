package BOJ.DP;

import java.util.Scanner;

public class 이친수_2193번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 단순 피보나치 수열의 값을 구하는게 아니다.
        // n이 1개일때 값도 고려해야한다.
        // 아래의 경우 n = 1일때 dp[2]의 값이 존재하지 않아서 에러

        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 1;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }


        System.out.println(dp[n]);
    }
}
