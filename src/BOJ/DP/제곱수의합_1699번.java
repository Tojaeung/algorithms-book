package BOJ.DP;

import java.util.Scanner;

public class 제곱수의합_1699번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            // 최대의 제곱수만 확인하지 않고 모든 제곱수를 확인해서 그 중에 최소값을 dp에 반영한다.
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        // 아이디어: 최대 제곱수를 빼면 최적의 결과가 나오지 않을까??
        // 반례: 12일때 정답은 3이지만 아래의 코드는 4가 나온다.
        // 즉, 무조건 최대 제곱수를 빼준다고 최적의 결과가 나오지 않는것을 고려해야한다.

        // for (int i = 1; i <= n; i++) {
        //     dp[i] = dp[i - ((int) Math.sqrt(i) * (int) Math.sqrt(i))] + 1;
        // }

        System.out.println(dp[n]);
    }
}
