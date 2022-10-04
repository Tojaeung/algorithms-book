package BOJ.DP;

import java.util.Scanner;

public class 일이삼더하기_9095번 {
    public static int testCase, n;
    public static int[] dp = new int[11];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++) {

            n = sc.nextInt();

            // 보텀업 dp문제
            dp[1] = 1;  // 경우의 수들에게 3을 추가
            dp[2] = 2;  // 경우의 수들에게 2을 추가
            dp[3] = 4;  // 경우의 수들에게 1을 추가

            dp[4] = 7;

            for (int i = 4; i <= n; i++) {
                // 점화식
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            int result = dp[n];
            System.out.println(result);
        }
    }
}
