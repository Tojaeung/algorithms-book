package BOJ.DP;

import java.util.Scanner;

public class 포도주시식_2156번 {
    public static int n;
    public static int[] arr = new int[10001];
    public static int[] dp = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // dp는 n마다 최대로 마실수 있는 포도주
        dp[1] = arr[1]; // 포도주가 1개 주어지면 최대로 마실수 있는 포도주도 1개
        dp[2] = arr[1] + arr[2];    // 포도주가 2개 주어지면 최대로 마실수 있는 포도주도 2개
        for (int i = 3; i <= n; i++) {
            // OXO
            // OXOO
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
            // ??OX
            // i번째 포도주를 마시지 않는 경우
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
