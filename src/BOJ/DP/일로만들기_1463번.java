package BOJ.DP;

import java.util.Scanner;

public class 일로만들기_1463번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];  // 배열 인덱스가 되기위한 최소 연산 수  

        dp[1] = 0;  // 1은 이미 1이므로 연산할 필요가 없음
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);

    }
}
