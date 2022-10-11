package BOJ.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 연속합_1912번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 점화식 도출이 어렵게 느껴진다...ㅠ
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1] = Math.max(dp[i] + arr[i + 1], arr[i + 1]);
        }

        Arrays.sort(dp);
        System.out.println(dp[n - 1]);

    }
}
