package BOJ.DP;

import java.util.Scanner;

public class 카드구매하기1_11052번 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        // 1개의 카드를 최대의 비용으로 뽑는다.
        // 2개의 카드를 최대의 비용으로 뽑는다.
        // 3개의 카드를 최대의 비용으로 뽑는다.
        // 4개의 카드를 최대의 비용으로 뽑는다.
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {

                // EX: n =4 일때
                // 1개를 뽑을수 있는 최대의 비용에 카드팩3을 구매한다.
                // 2개를 뽑을수 있는 최대의 비용에 카드팩2을 구매한다.
                // 3개를 뽑을수 있는 최대의 비용에 카드팩1을 구매한다.
                // 카드팩4를 구매한다.
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
