package BOJ.DP;

import java.util.Scanner;

public class 타일링2xN1_11726번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        // n이 1인경우도 고려해야한다.(배열 크기 조절)
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n; i++) {
            // (n - 2)에서 각각 1*2 타일을 붙히고
            // (n - 1)에서 각각 2*1 타일을 붙히면 된다.
            dp[i] = ((dp[i - 1] + (2 * dp[i - 2]))) % 10007;
        }

        System.out.println(dp[n - 1]);
    }
}
